package com.example.hanzq.masterlecture;

import java.util.ArrayList;

/**
 * Created by HanZQ on 2015/3/21.
 */
public class Walkman {
    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final String title;
    public final String content;
    public int imageViewId;

    public Walkman(int type,int imageViewId, String title,String content) {
        this.type = type;
        this.imageViewId=imageViewId;
        this.title = title;
        this.content=content;
    }

    @Override public String toString() {
        return null;
    }
    public static ArrayList<Walkman> getData(){
        ArrayList<Walkman>  list=new ArrayList<Walkman>();
        list.add(new Walkman(SECTION,R.drawable.ic_launcher ,"Lever 1",""));
        list.add(new Walkman(ITEM,R.drawable.walkman_lv1_c1 , "声音的魅力","音频原理学习资料"));
        list.add(new Walkman(ITEM,R.drawable.walkman_lv1_c2 , "好声音哪里来？","音频系统的组成和功能"));
        list.add(new Walkman(ITEM,R.drawable.walkman_lv1_c3 , "好声音之源","领略音频格式的帝国"));
        list.add(new Walkman(ITEM,R.drawable.walkman_lv1_c4 , "Hi-Res Audio课堂","高解析度音频的魅力"));
        return list;
    }
}
