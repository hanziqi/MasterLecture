package com.example.hanzq.masterlecture;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import libcore.io.DiskLruCache;

/**
 * Created by HanZQ on 2015/4/23.
 */
public class SettingActivity extends Activity {

    SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Switch swc;
    private TextView clearCache;
    RelativeLayout removeCache;
    private DiskLruCache mDiskLruCache;
    PhotoWallAdapter mAdapter;
    GridView mPhotoWall;

    IntentFilter intentFilter;
    private PhotoWallAdapter.LocalReceiver localReceiver1;
    private LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getActionBar();
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View titleView = inflater.inflate(R.layout.titlebar, null);
        actionBar.setCustomView(titleView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText("设置");
        ImageView imageView = (ImageView) actionBar.getCustomView().findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.quit_zoom_in,R.anim.quit_zoom_out);
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        swc= (Switch)findViewById(R.id.wifi_switch);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember=pref.getBoolean("is_remember",false);
        if(isRemember){
            swc.setChecked(true);
        }
        clearCache= (TextView) findViewById(R.id.clear_cache);
        try {
            mAdapter=new PhotoWallAdapter(this, 0, WalkmanImageL1C2.imageThumbUrls,mPhotoWall);
            mDiskLruCache= DiskLruCache.open(mAdapter.getDiskCacheDir(this, "thumb"), 1, 1, 200*1024*1024);
            long size=mDiskLruCache.size()/1024/1024;
            clearCache.setText(size+"MB");
        } catch (IOException e) {
            e.printStackTrace();
        }
        removeCache= (RelativeLayout) findViewById(R.id.remove_cache);
        removeCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(SettingActivity.this);
                dialog.setTitle("手动清理缓存");
                dialog.setMessage("本地缓存将被清空");
                dialog.setCancelable(true);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    try {
                        mDiskLruCache.delete();
                        Toast.makeText(SettingActivity.this, "缓存已清空", Toast.LENGTH_SHORT).show();
                        clearCache.setText("0MB");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }
                });
                dialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        editor=pref.edit();
        swc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swc.isChecked()){
                    editor.putBoolean("is_remember",true);
                    Toast.makeText(SettingActivity.this,"Wi-Fi环境下将不消耗流量",Toast.LENGTH_SHORT).show();
                }else {
                    editor.putBoolean("is_remember",false);
                    Toast.makeText(SettingActivity.this,"Wi-Fi若未连接，将消耗流量",Toast.LENGTH_SHORT).show();
                }
                editor.apply();
                Intent intent1=new Intent("1");
                localBroadcastManager.sendBroadcast(intent1);
            }
        });
        intentFilter=new IntentFilter();
        intentFilter.addAction("1");
        localReceiver1=new PhotoWallAdapter.LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver1,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.quit_zoom_in,R.anim.quit_zoom_out);
    }
}
