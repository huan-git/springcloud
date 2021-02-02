package com.ahuan.common.annotation;

/**
 * @author ahuan
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/210:45
 */

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Excel {

    String name() default  "";
}
