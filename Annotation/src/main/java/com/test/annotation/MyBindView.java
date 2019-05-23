package com.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jackyshu at 2019/5/23
 *
 * @description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface MyBindView {
    int value();
}
