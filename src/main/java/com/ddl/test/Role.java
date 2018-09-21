package com.ddl.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
public @interface Role {
    String value() default "";
}
