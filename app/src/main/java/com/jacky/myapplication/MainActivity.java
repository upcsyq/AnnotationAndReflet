package com.jacky.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jacky.myapplication.Annotation.AnnotationTest;
import com.jacky.myapplication.reflect.ReflectA;
import com.jacky.myapplication.reflect.ReflectTest;
import com.test.annotation.Template;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


@Template()
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EventBus.builder().ignoreGeneratedIndex(false).addIndex(new MyEventBusIndex()).installDefaultEventBus();
        EventBus.getDefault().register(this);

        initView();
        testReflect();

        testAnnotation();
    }

    private void testAnnotation() {
        AnnotationTest test = new AnnotationTest();
        test.printA();

//        com.test.annotation.jacky  myAnn = new jacky();
//        Log.i("TAG", myAnn.getMessage());
    }

    private void testReflect() {
//        ReflectTest.getInstance().printAllFunction();
//        ReflectTest.getInstance().printAllFunction2();
//        ReflectTest.getInstance().printPrivateVar();
//        ReflectTest.getInstance().printPublicVar();
//        ReflectTest.getInstance().reflectCallPrivateMethod();
//        ReflectTest.getInstance().reflectCallPublicMethod();
//        ReflectTest.getInstance().testArray();
    }

    private void initView() {
        findViewById(R.id.hl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("Hello world!"));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        /* Do something */
        Log.d("eventbus3", "onMessageEvent msg=" + event.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
