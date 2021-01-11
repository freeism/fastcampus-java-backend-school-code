package com.fastcampus.todo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Martin
 * @since 2021/01/11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface CustomLog {
}
