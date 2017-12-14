package com.codetutor.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anildeshpande on 11/16/17.
 */

public class FragmentTwo extends Fragment {
    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = FragmentTwo.class.getSimpleName();

    private static final String TAG = COMMON_TAG;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample_two,container,false);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
