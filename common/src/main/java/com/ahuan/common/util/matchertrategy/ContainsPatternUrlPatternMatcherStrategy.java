package com.ahuan.common.util.matchertrategy;

/**
 * @author huan
 */
public final class ContainsPatternUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    private String pattern;

    public boolean matches(final String url) {
        return url.contains(this.pattern);
    }

    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }
}
