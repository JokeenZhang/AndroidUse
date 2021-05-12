package com.zzq.jni;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zzq.jni.model.HelloJni;
import com.zzq.jni.model.JniAndHeaderFile;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg1;
    private TextView tvMsg2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg1 = findViewById(R.id.tv_msg1);
        tvMsg1.setText(HelloJni.helloJniAndMsg());

        tvMsg2 = findViewById(R.id.tv_msg2);
        tvMsg2.setText(JniAndHeaderFile.fromJniAndHeaderFile("MainActivity"));
    }
}
