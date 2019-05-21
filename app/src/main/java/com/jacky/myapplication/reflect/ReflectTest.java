package com.jacky.myapplication.reflect;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by jackyshu at 2019/5/15
 *
 * @description:
 */
public class ReflectTest {
    private static final String TAG = ReflectTest.class.getSimpleName();

    private static ReflectTest instance;

    private ReflectTest() {

    }

    public static ReflectTest getInstance() {
        if (instance == null) {
            instance = new ReflectTest();
        }

        return instance;
    }

    /**
     * 打印了ReflectA中自己声明的方法
     */
    public void printAllFunction() {
        Class<?> cl = ReflectA.class;
        Method[] m = cl.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            Log.d(TAG, "printAllFunction method=" + m[i]);
        }
    }

    /**
     * 打印了ReflectA中自己声明的方法和Object的方法
     */
    public void printAllFunction2() {
        Class<?> cl = ReflectA.class;
        Method[] m = cl.getMethods();
        for (int i = 0; i < m.length; i++) {
            Log.d(TAG, "printAllFunction method=" + m[i]);
            //得到方法的返回值类型的类类型
            Class retrunType = m[i].getReturnType();
            Log.d(TAG, "printAllFunction retrunType=" + retrunType.getName());
            //得到方法的名称
            System.out.print(m[i].getName()+"(");
            Log.d(TAG, "printAllFunction " + m[i].getName()+"(");
            //获取的参数类型--->得到的是参数列表的类型的类类型
            Class[] paraTypes = m[i].getParameterTypes();
            for(Class class1 : paraTypes){
                Log.d(TAG, "printAllFunction " + class1.getName()+",");
            }
        }
    }

    public void printPrivateVar() {
        ReflectA a = new ReflectA(3, 4);
        try {
            Field y = a.getClass().getDeclaredField("y");//getDeclaredField--private
            y.setAccessible(true);//setAccessible
            Object yy = y.get(a);
            Log.d(TAG, "printPrivateVar y=" + (int) yy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void printPublicVar() {
        ReflectA a = new ReflectA(3, 4);
        try {
            Field x = a.getClass().getField("x");//getField--public
            Object xx = x.get(a);
            Log.d(TAG, "printPublicVar x=" + (int) xx);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void reflectCallPrivateMethod() {
        //如何反射带参数的构造函数
        Class<?> cl = ReflectA.class;
        try {
            Constructor c = cl.getConstructor(int.class, int.class);
            Object a = c.newInstance(3, 4);
            Method m = ReflectA.class.getDeclaredMethod("print2", String.class);
            if(m.getModifiers() == Modifier.PRIVATE) {
                m.setAccessible(true);
            }
            m.invoke(a, "fucktest2");//invoke
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void reflectCallPublicMethod() {
        //如何反射带参数的构造函数
        Class<?> cl = ReflectA.class;
        try {
            Constructor c = cl.getConstructor(int.class, int.class);
            Object a = c.newInstance(4, 5);
            Method m = ReflectA.class.getMethod("print", String.class);
            m.invoke(a, "fucktest");//invoke
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void testArray(){
        int[] a = new int[3];
        int[] b = new int[]{4,5,5};//直接赋值后不可以指定长度，否则ＣＥ
        int[][] c = new int[3][2];
        String[] d = new String[]{"jjj","kkkk"};
        int e = 3;

        Log.d(TAG, "testArray a.class=" + a.getClass());
        Log.d(TAG, "testArray b.class=" + b.getClass());
        Log.d(TAG, "testArray c.class=" + c.getClass());
        Log.d(TAG, "testArray d.class=" + d.getClass());
//        Log.d(TAG, "testArray e.class=" + e.getClass());//error 不是类啊
        Log.d(TAG, "testArray e.class=" + int.class);
        Log.d(TAG, "testArray ReflectA.class=" + ReflectA.class);
    }
}
