package com.ahuan.common.util;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import com.ahuan.common.annotation.Excel;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author ahuan
 * @version 1.0
 * @description 读取较大的excel文件防止内存溢出(兼容Excel2003和2007)
 * @since 2020/06/01
 */
public class ReadExcel2003Or2007 {
    private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
    private List<String> headers;
    private Map<String, String> aliasHeader;
    private final OPCPackage xlsxPackage;
    private int headerRow;
    private int columns;

    private class SheetToCSV implements SheetContentsHandler {
        private String[] record;
        private int minColumns;

        public SheetToCSV(int minColumns) {
            super();
            this.minColumns = minColumns;
        }

        @Override
        public void startRow(int rowNum) {
            record = new String[this.minColumns];
        }

        @Override
        public void endRow(int rowNum) {
            if (headerRow == rowNum + 1) {
                headers = Arrays.asList(this.record);
            } else {
                if (aliasHeader == null) {
                    rows.add(IterUtil.toMap(headers, Arrays.asList(this.record)));
                } else {
                    rows.add(IterUtil.toMap(aliasHeader(headers, aliasHeader), Arrays.asList(this.record)));
                }
            }
        }

        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            int thisCol = (new CellReference(cellReference)).getCol();
            record[thisCol] = formattedValue;

        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {
            // Skip, no headers or footers in CSV
        }

    }

    public ReadExcel2003Or2007(OPCPackage pkg, int headerRow, int columns) {
        this.xlsxPackage = pkg;
        this.headerRow = headerRow;
        this.columns = columns;
    }

    public ReadExcel2003Or2007(OPCPackage pkg, Map<String, String> aliasHeader, int headerRow, int columns) {
        this.xlsxPackage = pkg;
        this.aliasHeader = aliasHeader;
        this.headerRow = headerRow;
        this.columns = columns;
    }

    /**
     * 表头转换
     *
     * @param headerList
     * @param headerAlias
     * @return
     */
    private static List<String> aliasHeader(List<String> headerList, Map<String, String> headerAlias) {
        ArrayList<String> result = new ArrayList();
        if (CollUtil.isEmpty(headerList)) {
            return result;
        } else {
            String alias = null;

            for (Iterator iterator = headerList.iterator(); iterator.hasNext(); result.add(alias)) {
                Object headerObj = iterator.next();
                if (null != headerObj) {
                    String header = headerObj.toString();
                    alias = (String) headerAlias.get(header);
                    if (null == alias) {
                        alias = header;
                    }
                }
            }
            return result;
        }
    }

    public void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, SheetContentsHandler sheetHandler, InputStream sheetInputStream)
            throws IOException, ParserConfigurationException, SAXException {
        DataFormatter formatter = new DataFormatter();
        InputSource sheetSource = new InputSource(sheetInputStream);
        try {
            XMLReader sheetParser = SAXHelper.newXMLReader();
            ContentHandler handler = new XSSFSheetXMLHandler(styles, null, strings, sheetHandler, formatter, false);
            sheetParser.setContentHandler(handler);
            sheetParser.parse(sheetSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    public List<Map<String, Object>> process() throws IOException, OpenXML4JException, ParserConfigurationException, SAXException {
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
        XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
        StylesTable styles = xssfReader.getStylesTable();
        XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        int index = 0;
        while (iter.hasNext()) {
            InputStream stream = iter.next();
            String sheetName = iter.getSheetName();
            processSheet(styles, strings, new SheetToCSV(this.columns), stream);
            stream.close();
            ++index;
        }
        return this.rows;
    }

    /**
     * 该方法返回 List<Map<String, Object>>
     *
     * @param excelPath
     * @param headerRow 表头行
     * @param columns   输出多少列
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getRecords(String excelPath, int headerRow, int columns) throws Exception {
        File xlsxFile = new File(excelPath);
        if (!xlsxFile.exists()) {
            System.err.println("Not found or not a file: " + xlsxFile.getPath());
            return null;
        }
        OPCPackage p = OPCPackage.open(xlsxFile);
        ReadExcel2003Or2007 xlsx2csv = new ReadExcel2003Or2007(p, headerRow, columns);
        List<Map<String, Object>> list = xlsx2csv.process();
        p.close();
        return list;
    }

    /**
     * 该方法返回 List<Map<String, Object>>
     *
     * @param excelPath
     * @param headerRow   表头行
     * @param aliasHeader
     * @param columns     输出多少列
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getRecords(String excelPath, int headerRow, int columns, Map<String, String> aliasHeader) throws Exception {
        File xlsxFile = new File(excelPath);
        if (!xlsxFile.exists()) {
            System.err.println("Not found or not a file: " + xlsxFile.getPath());
            return null;
        }
        OPCPackage p = OPCPackage.open(xlsxFile);
        ReadExcel2003Or2007 xlsx2csv = new ReadExcel2003Or2007(p, aliasHeader, headerRow, columns);
        List<Map<String, Object>> list = xlsx2csv.process();
        p.close();
        return list;
    }

    /**
     * 该方法返回对象
     *
     * @param excelPath
     * @param headerRow 表头行
     * @param columns
     * @param beanType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> getRecords(String excelPath, int headerRow, int columns, Class<T> beanType) throws Exception {
        Map<String, String> aliasHeader = getFiledMap(beanType);
        List<Map<String, Object>> mapList = getRecords(excelPath, headerRow, columns, aliasHeader);
        if (Map.class.isAssignableFrom(beanType)) {
            return (List<T>) mapList;
        } else {
            List<T> beanList = new ArrayList(mapList.size());
            Iterator iterator = mapList.iterator();

            while (iterator.hasNext()) {
                Map<String, Object> map = (Map) iterator.next();
                beanList.add(BeanUtil.mapToBean(map, beanType, false));
            }
            return beanList;
        }
    }

    public static Map<String, String> getFiledMap(Class<?> clazz) {
        BeanDesc beanDesc = BeanUtil.getBeanDesc(clazz);
        Collection<BeanDesc.PropDesc> props = beanDesc.getProps();
        Map<String, String> filedMap = new HashMap<>(props.size());
        for (BeanDesc.PropDesc p : props) {
            Field field = beanDesc.getField(p.getFieldName());
            Excel annotation = field.getAnnotation(Excel.class);
            if (annotation != null) {
                filedMap.put(annotation.name(), p.getFieldName());
            }
        }
        return filedMap;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> aliasHeader = new HashMap<>();
        aliasHeader.put("姓名", "rymc");
        aliasHeader.put("联系方式（手机号）", "lxfs");
        aliasHeader.put("身份证号", "ryzjhm");
        aliasHeader.put("目前居住地址", "qymc");
        aliasHeader.put("在郑住址行政区", "xzqh");
        //需要的参数 是  excel文件的地址,和 一共有多少列
//        List<TestBean> records = getRecords("C:\\Users\\huan\\Downloads\\6.1大数据表2.xlsx", 1, 5, TestBean.class);
//        List<Map<String, Object>> records = getRecords("C:\\Users\\huan\\Downloads\\6.1大数据表2.xlsx", 1, 5, aliasHeader);
        List<Map<String, Object>> records = getRecords("C:\\Users\\huan\\Downloads\\6.1大数据表2.xlsx", 1, 5);

        System.out.println(records);
    }
}