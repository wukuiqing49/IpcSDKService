package com.wu.ipcservice;

import android.os.RemoteException;

import com.wu.ipc.IShareDataInterface;
import com.wu.ipc.IShareDataListener;

import java.util.HashMap;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2023/7/30
 * <p>
 * 用途:
 */


public class ShareDataBinder extends IShareDataInterface.Stub {

    IShareDataListener mCallBack;

    HashMap<Integer,String> mCacheMap= new HashMap<>();

    @Override
    public void sendShareData(int key, String values) {
        if (mCallBack!=null){
            try {
                mCallBack.notifyShareData(key,values);
                mCacheMap.put(key,values);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String getShareData(int key)  {
        try {
            String content= mCacheMap.get(key);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void registerCallback(int id, IShareDataListener callback) {
        mCallBack=callback;
    }

    @Override
    public void unregisterCallback(IShareDataListener callback) {

    }
}
