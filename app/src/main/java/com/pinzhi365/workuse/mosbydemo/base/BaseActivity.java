package com.pinzhi365.workuse.mosbydemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.pinzhi365.workuse.mosbydemo.annotation.InjectActivity;
import com.pinzhi365.workuse.mosbydemo.annotation.InjectView;

import java.lang.reflect.Field;

abstract class BaseActivity extends Activity {
    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setInjectContentView();
        try {
            setInjectFindViewId();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void setInjectContentView() {
        if (this.getClass().isAnnotationPresent(InjectActivity.class)) {
            InjectActivity injectActivity = this.getClass().getAnnotation(InjectActivity.class);
            int id = injectActivity.id();
            if (id != -1) {
                setContentView(id);
            }
        }
    }

    private void setInjectFindViewId() throws IllegalAccessException {
        Class clazz = getClass();
        //得到该Activity的所有字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectView.class)) {
                int id = field.getAnnotation(InjectView.class).id();
                if (id > 0) {
                    field.setAccessible(true);
                    field.set(this, findViewById(id));
                }
            }
        }
    }
}
