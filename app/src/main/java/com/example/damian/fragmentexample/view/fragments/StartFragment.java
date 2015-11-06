package com.example.damian.fragmentexample.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.damian.fragmentexample.R;
import com.example.damian.fragmentexample.view.MainActivity;

/**
 * Created by Admin on 06.11.2015.
 */
public class StartFragment extends Fragment{
    Button btnGoToTabFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first,container,false);
        btnGoToTabFragment = (Button) v.findViewById(R.id.btnSwitchTabFragment);
        btnGoToTabFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int containerId = ((MainActivity)getActivity()).ROOT_FRAGMENT_ID;
                ((MainActivity)getActivity()).getTransitManager().switchFragment(containerId,new TabFragment(),null,true);
            }
        });
        return v;
    }
}
