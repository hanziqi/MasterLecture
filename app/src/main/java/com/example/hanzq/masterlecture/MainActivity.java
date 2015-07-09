package com.example.hanzq.masterlecture;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private WalkmanFragment walkmanFragment;
    private AlphaFragment alphaFragment;
    private BraviaFragment braviaFragment;
    
    View walkmanLayout;
    View alphaLayout;
    View braviaLayout;

    private ImageView walkmanImage;
    private ImageView alphaImage;
    private ImageView braviaImage;

    private TextView walkmanText;
    private TextView alphaText;
    private TextView braviaText;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager=getFragmentManager();
        setTabSelection(0);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        Log.d("oncreate", "save=====" + savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.enter_zoom_in,R.anim.enter_zoom_out);
                break;
            case R.id.action_map:
                Intent intent2 = new Intent(MainActivity.this, Map.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.enter_zoom_in,R.anim.enter_zoom_out);
                break;
            case R.id.action_about:
                Intent intent3 = new Intent(MainActivity.this, About.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.enter_zoom_in,R.anim.enter_zoom_out);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private int backPressedTime=0;
    @Override
    public void onBackPressed() {
        if(backPressedTime==0){
            Toast.makeText(this,"鍐嶆寜涓�娆￠��鍑虹储灏煎ぇ甯堢彮",Toast.LENGTH_SHORT).show();
            backPressedTime=1;
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        backPressedTime=0;
                    }
                    super.run();
                }
            }.start();
            return;
        }else {
            finish();
        }
        super.onBackPressed();
        overridePendingTransition(R.anim.main_quit_zoom_in, R.anim.main_quit_zoom_out);
    }

    private void initView() {
        walkmanLayout= findViewById(R.id.walkman_layout);
        alphaLayout= findViewById(R.id.alpha_layout);
        braviaLayout= findViewById(R.id.bravia_layout);
        walkmanImage= (ImageView) findViewById(R.id.walkman_image);
        alphaImage= (ImageView) findViewById(R.id.alpha_image);
        braviaImage= (ImageView) findViewById(R.id.bravia_image);
        walkmanText= (TextView) findViewById(R.id.walkman_text);
        alphaText= (TextView) findViewById(R.id.alpha_text);
        braviaText= (TextView) findViewById(R.id.bravia_text);
        walkmanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelection(0);
            }
        });
        alphaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelection(1);
            }
        });
        braviaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelection(2);
            }
        });
    }

    private void setTabSelection(int index) {

        clearSeletion();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
//        hideFragment(transaction);
        switch (index){
            case 0:
                walkmanImage.setImageResource(R.drawable.walkman_selected);
                walkmanText.setTextColor(Color.parseColor("#dafaf8"));
//                if(walkmanFragment==null){
                walkmanFragment=new WalkmanFragment();
                transaction.replace(R.id.content,walkmanFragment);
//                }else{
//                    transaction.show(walkmanFragment);
//                }
                break;
            case 1:
                alphaImage.setImageResource(R.drawable.alpha_selected);
                alphaText.setTextColor(Color.parseColor("#dafaf8"));
//                if(alphaFragment==null){
                alphaFragment=new AlphaFragment();
                transaction.replace(R.id.content,alphaFragment);
//                }else{
//                    transaction.show(alphaFragment);
//                }
                break;
            case 2:
                braviaImage.setImageResource(R.drawable.bravia_selected);
                braviaText.setTextColor(Color.parseColor("#dafaf8"));
//                if(braviaFragment==null){
                braviaFragment=new BraviaFragment();
                transaction.replace(R.id.content,braviaFragment);
//                }else{
//                    transaction.show(braviaFragment);
//                }
                break;
        }
        transaction.commit();
    }

    private void clearSeletion() {
        walkmanImage.setImageResource(R.drawable.walkman_unselected);
        walkmanText.setTextColor(Color.parseColor("#82858b"));
        alphaImage.setImageResource(R.drawable.alpha_unselected);
        alphaText.setTextColor(Color.parseColor("#82858b"));
        braviaImage.setImageResource(R.drawable.bravia_unselected);
        braviaText.setTextColor(Color.parseColor("#82858b"));
    }

    private void hideFragment(FragmentTransaction transaction) {
        if(walkmanFragment!=null){
            transaction.hide(walkmanFragment);
        }
        if(alphaFragment!=null){
            transaction.hide(alphaFragment);
        }
        if(braviaFragment!=null){
            transaction.hide(braviaFragment);
        }
    }

}
