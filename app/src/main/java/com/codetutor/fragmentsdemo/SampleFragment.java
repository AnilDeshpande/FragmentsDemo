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

    private static final String TAG = SampleFragment.class.getSimpleName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG," onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG," onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG," onCreateView");
        return inflater.inflate(R.layout.fragment_sample,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG," onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG," onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG," onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG," onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG," onStop");
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        Log.i(TAG," onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG," onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG," onDetach");
        super.onDetach();
    }
}
