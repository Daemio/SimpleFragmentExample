package com.example.damian.fragmentexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.damian.fragmentexample.R;
import com.example.damian.fragmentexample.view.fragments.StartFragment;
import com.example.damian.fragmentexample.view.fragments.TabFragment;
import com.example.damian.fragmentexample.view.transit.TransitManager;

public class MainActivity extends AppCompatActivity {
    TransitManager transitManager;
    public static final int ROOT_FRAGMENT_ID = R.id.flMain;

    public TransitManager getTransitManager() {
        return transitManager;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transitManager = new TransitManager(this);
        initStartFragment();
    }

    private void initStartFragment(){
        ((FrameLayout)findViewById(ROOT_FRAGMENT_ID)).removeAllViews();
        transitManager.switchFragment(ROOT_FRAGMENT_ID, new StartFragment(), null, true);
    }

    public void onBackPressed() {
//        int count = getFragmentManager().getBackStackEntryCount();
//
//        if (count == 1) {
//            super.onBackPressed();
//        } else {
//            getFragmentManager().popBackStack();
//        }

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            super.onBackPressed();
        } else {
            if(count == 2) {
                getFragmentManager().popBackStack();
            }else {
                while (count>2){
                    getFragmentManager().popBackStack();
                    count--;
                }
            }
        }


        return;
    }

}
