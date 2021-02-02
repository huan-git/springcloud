package com.ahuan.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户 IP 地址
 * 
 * @author Huan
 *
 */
public class IpAddressUtil {
    private static final Logger logger = LoggerFactory.getLogger(IpAddressUtil.class);

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址, 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        String strUnKnown = "unknown";
        if (ip != null && ip.length() != 0 && !strUnKnown.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            String str = ",";
            if (ip.indexOf(str) != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            // logger.debug("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            // logger.debug("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            // logger.debug("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            // logger.debug("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            // logger.debug("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || strUnKnown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            // logger.debug("getRemoteAddr ip: " + ip);
        }
        logger.debug("client ip: " + ip);
        return ip;
    }
}