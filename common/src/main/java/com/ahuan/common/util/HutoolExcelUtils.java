package com.ahuan.common.util;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelUtil;
import com.ahuan.common.annotation.Excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/***
 * @ClassName Test
 * @Description: Test.java
 * @Author Ahuan
 * @Date 2020/5/26 
 * @Version V1.0
 **/
public class HutoolExcelUtils {


    private static <T> List<T> readBySax(InputStream inputStream,int sheet, int headerRow, Class<T> beanType) {
        boolean xlsx = ExcelUtil.isXlsx(inputStream);
        List<String> headers=new ArrayList<>();
        List<T> resList = new ArrayList<>();
        if (xlsx) {
            ExcelUtil.read07BySax(inputStream, sheet, (sheetIndex, rowIndex, rowlist) -> {
                getRecords(resList,headers,headerRow,rowIndex,rowlist,beanType);
            });
        } else {
            ExcelUtil.read03BySax(inputStream, sheet, (sheetIndex, rowIndex, rowlist) -> {
                getRecords(resList,headers, headerRow, rowIndex, rowlist,beanType);
            });
        }
        return resList;
    }



    private static List<Map<String, Object>> readBySax(InputStream inputStream, int sheet, int headerRow) {
        boolean xlsx = ExcelUtil.isXlsx(inputStream);
        List<String> headers=new ArrayList<>();
        List<Map<String, Object>> resList = new ArrayList<>();
        if (xlsx) {
            ExcelUtil.read07BySax(inputStream, sheet, (sheetIndex, rowIndex, rowlist) -> {
                getRecords(resList, headers,null, headerRow, rowIndex, rowlist);
            });
        } else {
            ExcelUtil.read03BySax(inputStream, sheet, (sheetIndex, rowIndex, rowlist) -> {
                getRecords(resList,headers, null, headerRow, rowIndex, rowlist);
            });
        }
        return resList;
    }

    public static void main(String[] args) {

        BufferedInputStream inputStream = FileUtil.getInputStream(new File("C:\\Users\\huan\\Downloads\\6.2大数据表2.xls"));
//        List<TestBean> mapList = readBySax(inputStream, 0,1, TestBean.class);
        List<Map<String, Object>> mapList = readBySax(inputStream, 0, 1);
        System.out.println(mapList);
    }

    private static void getRecords(List<Map<String, Object>> resList, List<String> headers , Map<String, String> aliasHeader, int headerRow, int rowIndex, List<Object> rowlist) {
        if (headerRow == rowIndex + 1) {
            rowlist.forEach(e -> headers.add(e.toString()));
        } else {
            if (aliasHeader == null || aliasHeader.isEmpty()) {
                resList.add(IterUtil.toMap(headers, rowlist));
            } else {
                resList.add(IterUtil.toMap(aliasHeader(headers, aliasHeader), rowlist));
            }
        }
    }

    private static <T> void getRecords(List<T> resList, List<String> headers , int headerRow, int rowIndex, List<Object> rowlist,Class<T> beanType) {
        Map<String, String> aliasHeader = getFiledMap(beanType);
        List<Map<String, Object>> mapList=new ArrayList<>();
        getRecords(mapList,headers,aliasHeader,headerRow,rowIndex,rowlist);
        if (Map.class.isAssignableFrom(beanType)) {
            //     nothing to do
        } else {
            Iterator iterator = mapList.iterator();

            while (iterator.hasNext()) {
                Map<String, Object> map = (Map) iterator.next();
                resList.add(BeanUtil.mapToBean(map, beanType, false));
            }
        }
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

    /**
     * @param clazz
     * @return
     */
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
}