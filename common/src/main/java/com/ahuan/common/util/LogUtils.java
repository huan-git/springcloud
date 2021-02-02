package com.ahuan.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .日志工具类
 *
 * @author huan
 * @version v1.0
 * @date 2019年7月22日
 */
public class LogUtils {

    /**
     * .获取日志对象
     *
     * @param clazz
     * @return
     * @author huan
     * @date 2019年7月22日
     * @version v1.0
     */
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getSimpleName());
    }

    /**
     * .获取日志对象
     *
     * @param clazzName
     * @return
     * @author huan
     * @date 2019年7月22日
     * @version v1.0
     */
    public static Logger getLogger(String clazzName) {
        return LoggerFactory.getLogger(clazzName);
    }

}