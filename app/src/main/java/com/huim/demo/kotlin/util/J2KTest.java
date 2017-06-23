package com.huim.demo.kotlin.util;

import android.content.Context;

import com.huim.demo.kotlin.R;


public class J2KTest {

    String[] datas;


    private void res(Context context){
        datas=context.getResources().getStringArray(R.array.demo_class);
    }

}
