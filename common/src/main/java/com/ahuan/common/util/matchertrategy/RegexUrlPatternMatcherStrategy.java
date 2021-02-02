package com.ahuan.common.util.matchertrategy;

import java.util.regex.Pattern;

/***
 *
 * @author huan
 *
 */
public final class RegexUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    private Pattern pattern;

    public RegexUrlPatternMatcherStrategy() {
    }

    public RegexUrlPatternMatcherStrategy(final String pattern) {
        this.setPattern(pattern);
    }

    public boolean matches(final String url) {
        return this.pattern.matcher(url).find();
    }

    public void setPattern(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
}