package com.zzq.test.utils;

import android.content.Context;

import androidx.annotation.Nullable;

public class SpUtil {
    private SpUtil() {

    }

    public static void saveData(Context context, String key, String data) {
        context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE)
                .edit()
                .putString(key, data)
                .commit();
    }

    @Nullable
    public static String getData(Context context, String key) {
        return context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE)
                .getString(key, null);
    }
}
