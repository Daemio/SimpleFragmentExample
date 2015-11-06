package com.example.damian.fragmentexample.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.damian.fragmentexample.R;
import com.example.damian.fragmentexample.view.Utils;

/**
 * Created by Admin on 06.11.2015.
 */
public class DetailFragment extends Fragment{
    private int fragmentNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNumber = getArguments().getInt(Utils.DETAIL_FRAGMENT_BUNDLE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(fragmentNumber == Utils.FIRST){
            return inflater.inflate(R.layout.detail1_fragment,container,false);
        }else{
            return inflater.inflate(R.layout.detail2_fragment,container,false);
        }
    }
}
