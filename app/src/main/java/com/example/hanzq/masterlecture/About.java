package com.example.hanzq.masterlecture;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HanZQ on 2015/4/14.
 */
public class About extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
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
        textView.setText("关于");
        ImageView imageView = (ImageView) actionBar.getCustomView().findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.quit_zoom_in,R.anim.quit_zoom_out);
            }
        });

        textView = (TextView) findViewById(R.id.tv3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:xZiqi.Han@sony.com.cn"));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.quit_zoom_in,R.anim.quit_zoom_out);
    }
}
