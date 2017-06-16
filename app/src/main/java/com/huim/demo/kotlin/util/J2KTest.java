package com.huim.demo.kotlin.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;


public class J2KTest {


    private void res(Context context){
        TelephonyManager manager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);

            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }

    private void check(final String urlStr){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlStr);
                    URLConnection uc=url.openConnection();
                    uc.connect();
                    long ld=uc.getDate();
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date=new Date(ld);
//                    RequestUtils.setRequestLog(urlStr,"接通网络时间 "+format.format(date));
                } catch (Exception e) {
//                    RequestUtils.setRequestLog(urlStr,"网络不通");
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void checkNetWork(Context context){
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info==null){
//            RequestUtils.setRequestLog("网络状态","无网络连接");
        }else{
            switch (info.getType()){
                case ConnectivityManager.TYPE_WIFI:
//                    RequestUtils.setRequestLog("网络状态","连接"+info.getTypeName());
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    String s="test"+info.getSubtype()+info.getSubtypeName();
//                    RequestUtils.setRequestLog("网络状态","连接"+info.getTypeName());
//                    RequestUtils.setRequestLog("网络状态","数据流量类型"+info.getSubtype()+" "+info.getSubtypeName());
                    break;
            }
        }
    }
}
