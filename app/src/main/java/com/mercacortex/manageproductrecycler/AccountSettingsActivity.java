package com.mercacortex.manageproductrecycler;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.mercacortex.manageproductrecycler.R;

/**
 * Created by usuario on 11/2/16.
 */

public class AccountSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_user);
    }
}
