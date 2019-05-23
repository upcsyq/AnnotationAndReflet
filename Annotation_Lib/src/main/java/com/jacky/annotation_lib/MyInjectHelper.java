package com.jacky.annotation_lib;

import android.app.Activity;

import java.lang.reflect.Constructor;

/**
 * Created by jackyshu at 2019/5/23
 *
 * @description:
 */
public class MyInjectHelper {
    public static void inject(Activity host) {
        String classFullName = host.getClass().getName() + "$$ViewInjector";
        try {
            Class proxy = Class.forName(classFullName);
            Constructor constructor = proxy.getConstructor(host.getClass());
            constructor.newInstance(host);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
