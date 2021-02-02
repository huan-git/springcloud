package com.ahuan.common.util.matchertrategy;

/**
 * @author huan
 */
public final class ExactUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    private String pattern;

    public ExactUrlPatternMatcherStrategy() {
    }

    public ExactUrlPatternMatcherStrategy(final String pattern) {
        this.setPattern(pattern);
    }

    public boolean matches(final String url) {
        return url.equals(this.pattern);
    }

    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }

}
