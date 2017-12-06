package com.codetutor.fragmentsdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anildeshpande on 10/25/17.
 */

public class SampleFragment extends Fragment {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = SampleFragment.class.getSimpleName();

    private static final String TAG = FRAGMENT_NAME;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" onCreateView");
        return inflater.inflate(R.layout.fragment_sample,container,false);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
