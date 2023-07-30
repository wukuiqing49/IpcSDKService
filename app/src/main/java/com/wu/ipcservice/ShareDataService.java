package com.wu.ipcservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2023/7/30
 * <p>
 * 用途:
 */


public class ShareDataService  extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ShareDataBinder();
    }
}
