package com.example.damian.fragmentexample.view.transit;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Created by Admin on 30.10.2015.
 */
public class TransitManager {

    private Activity activity;
    private FragmentManager fragmentManager;

    public TransitManager(Activity activity) {
        this.activity = activity;
        fragmentManager= activity.getFragmentManager();
    }

    public void switchFragment(int fragmentContainerRes,Fragment fragment){
        switchFragment(fragmentContainerRes,fragment, null, false);
    };

    public void switchFragment(int fragmentContainerRes,Fragment fragment, Bundle bundle){
        switchFragment(fragmentContainerRes,fragment, bundle, false);
    };

    public void switchFragment(int fragmentContainerRes,Fragment fragment, Bundle bundle, boolean addToStack){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (bundle!=null){
            fragment.setArguments(bundle);
        }
        if(addToStack){
            transaction.addToBackStack("");
        }
        transaction.replace(fragmentContainerRes, fragment).commitAllowingStateLoss();
    };

    public void back(){
        fragmentManager.popBackStack();
    }
}
