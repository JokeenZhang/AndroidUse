package com.zzq.test.utils;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

public class SpUtilTest {

    @Test
    public void saveData() {
        Context context = ApplicationProvider.getApplicationContext();
        String launchTime = SpUtil.getData(context, "LaunchTime");
        System.out.println("tetetetete " + launchTime);

    }
}