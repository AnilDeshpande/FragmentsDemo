package com.codetutor.fragmentsdemo;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCountriesFragment();
    }

    private void addCountriesFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        SampleFragment sampleFragment=new SampleFragment();
        sampleFragment.setFragmentActionListener(this);
        fragmentTransaction.add(R.id.fragmentContainer,sampleFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(String countryName){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        FragmentTwo sampleFragment=new FragmentTwo();
        Bundle bundle=new Bundle();
        bundle.putString("SELECTED_COUNTRY",countryName);
        sampleFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentContainer,sampleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCountrySelected(String country) {
        addCountryDescriptionFragment(country);
    }
}
