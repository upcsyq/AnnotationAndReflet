package com.jacky.myapplication.Annotation;

import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by jackyshu at 2019/5/16
 *
 * @description:
 */
public class AnnotationTest {
    private final static String TAG = AnnotationTest.class.getSimpleName();

    @EnableAuth(name="test")
    public void printA() {
        Class<?> clz = AnnotationTest.class;
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(EnableAuth.class)) {
                EnableAuth enableAuth = method.getAnnotation(EnableAuth.class);
                String name = enableAuth.name();
                Log.d(TAG, "printA method=" + method.getName() + ",name=" + name);
            }
        }
    }
}
