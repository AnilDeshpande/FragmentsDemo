package com.codetutor.fragmentsdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by anildeshpande on 10/25/17.
 */

public class SampleFragment extends Fragment{

    View rootView;

    ListView listViewCountries;
    ArrayAdapter<String> countryNamesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sample,container,false);
        initUI();
        return rootView;
    }

    private void initUI(){
        listViewCountries = (ListView)rootView.findViewById(R.id.listViewCountries);
        countryNamesAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.countries));
        listViewCountries.setAdapter(countryNamesAdapter);
    }
}
