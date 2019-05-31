package com.gaindecktechnologies.easychalo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context _context;

    // shared pref mode
    private int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "androidhive-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_LANGUAGE_SELECTED = "IsLanguageSelected";
    private static final String SELECTED_LANGUAGE = "SelectedLanguage";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {

        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);

    }

    public void setIsLanguageSelected(boolean isLanguageSelected) {
        editor.putBoolean(IS_LANGUAGE_SELECTED, isLanguageSelected);
        editor.commit();
    }

    public boolean isLanguageSelected() {

        return pref.getBoolean(IS_LANGUAGE_SELECTED, false);
    }

    public void setSelectedLanguage(String selectedLanguage) {

        editor.putString(SELECTED_LANGUAGE, selectedLanguage);
        editor.commit();

    }

    public String getSelectedLanguage() {

        return pref.getString(SELECTED_LANGUAGE, "English");
    }


}
