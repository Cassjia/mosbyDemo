package com.pinzhi365.workuse.mosbydemo;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceActivity;

public class MyMvpLcaActivity extends MvpLceActivity {
    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    @MainThread
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public void setData(Object data) {

    }
}
