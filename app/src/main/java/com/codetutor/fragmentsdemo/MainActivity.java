package com.codetutor.fragmentsdemo;


import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.activity_main_portrait)!= null){
            if(savedInstanceState==null){
                addCountriesFragment();
            }else{
                addCountryDescriptionFragment(savedInstanceState.getString("selectedCountry",null));
            }
        }else if (findViewById(R.id.activity_main_landscape)!=null){
            addCountriesFragment();
            if(savedInstanceState==null){
                addCountryDescriptionFragment(R.id.fragmentContainer2,"India");
            }else{

                addCountryDescriptionFragment(R.id.fragmentContainer2,savedInstanceState.getString("selectedCountry",null));
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("OrintationChange","MainActivity onSaveInstanceState");
        outState.putString("selectedCountry", selectedCountry);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("OrintationChange","MainActivity onSaveInstanceState");
        selectedCountry = savedInstanceState.getString("selectedCountry","India");
    }

    private void addCountriesFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountriesFragment countryListFragment=new CountriesFragment();
        countryListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer,countryListFragment);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();

        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void addCountryDescriptionFragment(int fragmentContainerId, String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();


        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryName);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(fragmentContainerId,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCountrySelected(String country) {
        selectedCountry = country;
        if(findViewById(R.id.activity_main_landscape)==null){
            addCountryDescriptionFragment(country);
        }else {
            addCountryDescriptionFragment(R.id.fragmentContainer2,country);
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            Log.i("OrintationChange", "landscape");

        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Log.i("OrintationChange", "portrait");
        }
    }
}
