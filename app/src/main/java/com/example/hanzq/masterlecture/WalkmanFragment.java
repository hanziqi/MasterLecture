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
 * Created by HanZQ on 2015/3/17.
 */
public class WalkmanFragment extends Fragment {
    private PinnedSectionListView listview;
    private WalkmanAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listview_layout,container,false);
        listview= (PinnedSectionListView) view.findViewById(R.id.listview);
        adapter=new WalkmanAdapter(getActivity(),Walkman.getData());
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
                    Intent intent1=new Intent(getActivity(),WalkmanLv1C1.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2=new Intent(getActivity(),WalkmanLv1C2.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3=new Intent(getActivity(),WalkmanLv1C3.class);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4=new Intent(getActivity(),WalkmanLv1C4.class);
                    startActivity(intent4);
                    break;
                default:
            }
            }
        });
        return view;
    }
}
