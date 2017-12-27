package com.codetutor.fragmentsdemo;

import android.os.Bundle;

/**
 * Created by anildeshpande on 12/26/17.
 */

public interface FragmentActionListener {

    String KEY_SELECTED_COUNTRY="KEY_SELECTED_COUNTRY";

    void onCountrySelected(String country);
}
