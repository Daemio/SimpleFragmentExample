package com.example.damian.fragmentexample.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.damian.fragmentexample.R;
import com.example.damian.fragmentexample.view.MainActivity;
import com.example.damian.fragmentexample.view.Utils;

/**
 * Created by Admin on 06.11.2015.
 */
public class TabFragment extends Fragment {
    RadioGroup rgTab;
    Button btnDetailsLeft;
    Button btnDetailsRight;
    TextView textView;
    FrameLayout flTabFragmentBody;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab_fragment,container,false);
        textView = (TextView) v.findViewById(R.id.tvTabFragmentCenterText);
        rgTab = (RadioGroup) v.findViewById(R.id.rgTab);
        btnDetailsLeft = (Button) v.findViewById(R.id.btnDetailsLeft);
        btnDetailsRight = (Button) v.findViewById(R.id.btnDetailsRight);
        flTabFragmentBody = (FrameLayout) v.findViewById(R.id.flTabFragmentBody);
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchTab(checkedId);
                textView.setText(checkedId == R.id.rbTab1 ? "LEFT TAB TEXT" : "RIGHT TAB TEXT");
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment fragment = new DetailFragment();
                Bundle args = new Bundle();

                switch (v.getId()){
                    case R.id.btnDetailsLeft:
                        args.putInt(Utils.DETAIL_FRAGMENT_BUNDLE_KEY, Utils.FIRST);
                        break;
                    case R.id.btnDetailsRight:
                        args.putInt(Utils.DETAIL_FRAGMENT_BUNDLE_KEY,Utils.SECOND);
                        break;
                    default:
                        return;
                }

                ((MainActivity) getActivity()).getTransitManager().switchFragment(R.id.flTabFragmentBody, fragment, args, true);

            }
        };
        btnDetailsLeft.setOnClickListener(listener);
        btnDetailsRight.setOnClickListener(listener);

        return v;
    }


    private void switchTab(int checkedId){
        if(checkedId == R.id.rbTab1){
            btnDetailsLeft.setVisibility(View.VISIBLE);
            btnDetailsLeft.setEnabled(true);
            btnDetailsRight.setVisibility(View.INVISIBLE);
            btnDetailsRight.setEnabled(false);
        }else{
            btnDetailsRight.setVisibility(View.VISIBLE);
            btnDetailsRight.setEnabled(true);
            btnDetailsLeft.setVisibility(View.INVISIBLE);
            btnDetailsLeft.setEnabled(false);
        }
    }
}
