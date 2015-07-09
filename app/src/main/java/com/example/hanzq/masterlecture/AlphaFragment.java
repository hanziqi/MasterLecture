package com.example.hanzq.masterlecture;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.hb.views.PinnedSectionListView;

/**
 * Created by HanZQ on 2015/3/21.
 */
public class AlphaFragment extends Fragment{
    private PinnedSectionListView listview;
    private AlphaAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listview_layout,container,false);
        listview= (PinnedSectionListView) view.findViewById(R.id.listview);
        adapter=new AlphaAdapter(getActivity(),Alpha.getData());
        listview.setAdapter(adapter);
//        LayoutAnimationController lac=new LayoutAnimationController(AnimationUtils.loadAnimation(getActivity(), R.anim.enter_zoom_in));
//        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        listview.setLayoutAnimation(lac);
//        listview.startLayoutAnimation();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        Intent intent1=new Intent(getActivity(),AlphaLv1C1.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(getActivity(),AlphaLv1C2.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(getActivity(),AlphaLv1C3.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(getActivity(),AlphaLv1C4.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(getActivity(),AlphaLv1C5.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6=new Intent(getActivity(),AlphaLv1C6.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7=new Intent(getActivity(),AlphaLv1C7.class);
                        startActivity(intent7);
                        break;
                    case 9:
                        Intent intent9=new Intent(getActivity(),AlphaLv2C1.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10=new Intent(getActivity(),AlphaLv2C2.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11=new Intent(getActivity(),AlphaLv2C3.class);
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12=new Intent(getActivity(),AlphaLv2C4.class);
                        startActivity(intent12);
                        break;
                    case 13:
                        Intent intent13=new Intent(getActivity(),AlphaLv2C5.class);
                        startActivity(intent13);
                        break;
                    case 14:
                        Intent intent14=new Intent(getActivity(),AlphaLv2C6_1.class);
                        startActivity(intent14);
                        break;
                    case 15:
                        Intent intent15=new Intent(getActivity(),AlphaLv2C6_2.class);
                        startActivity(intent15);
                        break;
                    case 16:
                        Intent intent16=new Intent(getActivity(),AlphaLv2C8.class);
                        startActivity(intent16);
                        break;
                    case 18:
                        Intent intent18=new Intent(getActivity(),AlphaLv3C1.class);
                        startActivity(intent18);
                        break;
                    case 19:
                        Intent intent19=new Intent(getActivity(),AlphaLv3C2.class);
                        startActivity(intent19);
                        break;
                    case 20:
                        Intent intent20=new Intent(getActivity(),AlphaLv3C3.class);
                        startActivity(intent20);
                        break;
                    case 21:
                        Intent intent21=new Intent(getActivity(),AlphaLv3C4.class);
                        startActivity(intent21);
                        break;
                    case 22:
                        Intent intent22=new Intent(getActivity(),AlphaLv3C5.class);
                        startActivity(intent22);
                        break;
                    case 23:
                        Intent intent23=new Intent(getActivity(),AlphaLv3C6.class);
                        startActivity(intent23);
                        break;
                    case 24:
                        Intent intent24=new Intent(getActivity(),AlphaLv3C7.class);
                        startActivity(intent24);
                        break;
                    default:
                }
            }
        });
        return view;
    }
}
