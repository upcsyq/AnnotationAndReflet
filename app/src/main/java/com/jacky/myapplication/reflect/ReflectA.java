package com.jacky.myapplication.reflect;

import android.util.Log;

import java.sql.Ref;

/**
 * Created by jackyshu at 2019/5/15
 *
 * @description:
 */
public class ReflectA {
    private static final String TAG = ReflectA.class.getSimpleName();
    public int x;
    private int y;

    public ReflectA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print(String test) {
        Log.d(TAG, "print test=" + test);
        Log.d(TAG, "print x=" + x);
        Log.d(TAG, "print y=" + y);
    }

    private void print2(String test) {
        Log.d(TAG, "print2 test=" + test);
        Log.d(TAG, "print2 x=" + x);
        Log.d(TAG, "print2 y=" + y);
    }

    public int getSum() {
        return x + y;
    }

    public int getSub() {
        return x - y;
    }

    public int getX() {
        return x * y;
    }

    private int testA() {
        return x * x;
    }

    @Override
    public String toString() {
        return "x=" + x + ",y=" + y;
    }
}
