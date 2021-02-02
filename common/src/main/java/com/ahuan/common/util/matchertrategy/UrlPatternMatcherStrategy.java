package com.ahuan.common.util.matchertrategy;

/**
 * @author huan
 */
public interface UrlPatternMatcherStrategy {

    boolean matches(String url);

    void setPattern(String pattern);
}