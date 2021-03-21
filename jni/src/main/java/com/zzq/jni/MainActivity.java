package com.zzq.jni;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("jni-test");
    }

    private TextView tvMsg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg = findViewById(R.id.tv_msg);
        tvMsg.setText(get());
        set("hello world from JniTestApp");
    }

    public native String get();

    public native void set(String str);
}
