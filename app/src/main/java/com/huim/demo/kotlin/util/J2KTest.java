package com.huim.demo.kotlin.util;

import android.content.Context;
import android.os.Bundle;

import com.huim.demo.kotlin.R;

import java.util.ArrayList;
import java.util.List;


public class J2KTest {

    List<test> list=new ArrayList<>();

    private void add(String _title, String _tag, Class<?> _class, Bundle _args){
        list.add(new test(_title,_tag,_class,_args));
    }

    private void res(Context context){
        String[] titles=context.getResources().getStringArray(R.array.home_viewpage_arrays);
        for (int i = 0; i < titles.length; i++) {
            String t=titles[i];
        }
        Class<?> c=J2KTest.class;
    }

    private class test{
        private final String tag;
        private final Class<?> clss;
        private final Bundle args;
        private final String title;

        public test(String _title, String _tag, Class<?> _class, Bundle _args) {
            title = _title;
            tag = _tag;
            clss = _class;
            args = _args;
        }
    }
}
