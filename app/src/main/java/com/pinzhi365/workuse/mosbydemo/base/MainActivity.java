package com.pinzhi365.workuse.mosbydemo.base;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pinzhi365.workuse.mosbydemo.R;
import com.pinzhi365.workuse.mosbydemo.annotation.InjectActivity;
import com.pinzhi365.workuse.mosbydemo.annotation.InjectView;

@InjectActivity(id = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @InjectView(id = R.id.recyclerView)
    RecyclerView mHello;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hahah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
