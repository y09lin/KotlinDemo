package com.huim.demo.kotlin.util

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo

/**
 * get install apps
 * Created by huim_lin on 2017/6/22.
 */
class RetrievePackages(val mContext:Context) {
    fun getInstallApps(getSystemApp:Boolean):List<PackageInfo>{
        val apps= ArrayList<PackageInfo>()
        val packages=mContext.packageManager.getInstalledPackages(0)
        packages.indices
                .map { packages[it] }
                .filterTo(apps) { !(it.versionName==null && !getSystemApp)
                        && it.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM ==0 }
        return apps
    }
}