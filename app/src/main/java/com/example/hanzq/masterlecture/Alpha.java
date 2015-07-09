package com.example.hanzq.masterlecture;

import java.util.ArrayList;

/**
 * Created by HanZQ on 2015/3/21.
 */
public class Alpha {
    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final String title;
    public final String content;
    public int imageViewId;

    public Alpha(int type,int imageViewId, String title,String content) {
        this.type = type;
        this.imageViewId=imageViewId;
        this.title = title;
        this.content=content;
    }

    @Override public String toString() {
        return null;
    }
    public static ArrayList<Alpha> getData(){
        ArrayList<Alpha>  list=new ArrayList<Alpha>();
        list.add(new Alpha(SECTION,R.drawable.ic_launcher ,"Lever 1",""));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c1 , "产品型号和特点-ILC_Part","微单主要功能及优势卖点"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c2 , "产品型号和特点-DSC&PV_Part","DSC/PV主要功能及优势卖点"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c3 , "基本操作和如何正确拍照","微单相机基本操作"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c4 , "A5100&A6000培训","APS-C画幅主推机型介绍"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c5 , "全幅微单A7系列培训","全画幅主推机型介绍"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c6 , "在售产品销售话术","微单及黑卡的优势及卖点"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv1_c7 , "镜头的分类","如何区分镜头"));
        list.add(new Alpha(SECTION,R.drawable.ic_launcher ,"Lever 2",""));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c1 , "什么是好的镜头","如何辨别好镜头"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c2 , "镜头销售话术","如何销售镜头"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c3 , "如何拍出好照片","好照片必备要素"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c4 , "蔡司和G镜头的优势","索尼高端镜头优势"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c5 , "FE镜头体系与优势","索尼E卡口镜头优势"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c6_1 , "初级摄影技巧1_光圈快门ISO","曝光三要素"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c6_2 , "初级摄影技巧2_对焦测光白平衡","拍照三要素"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv2_c8 , "高级操作技巧","微单优势功能操作讲解"));
        list.add(new Alpha(SECTION,R.drawable.ic_launcher ,"Lever 3",""));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c1 , "巧用自然光","光线充足情况下拍摄技巧"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c2 , "弱光摄影技巧","光线不充足情况下拍摄技巧"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c3 , "风光拍摄技巧","风光照片拍摄技巧"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c4 , "如何拍出好的人像照片","人像照片拍摄技巧"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c5 , "Lens Bar销售指南","门店如何结合Lens Bar加强镜头销售"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c6 , "深入了解配件知识","摄影配件的重要性及必要性"));
        list.add(new Alpha(ITEM,R.drawable.alpha_lv3_c7 , "摄像机产品知识","摄像机主要功能及优势卖点"));
        return list;
    }
}
