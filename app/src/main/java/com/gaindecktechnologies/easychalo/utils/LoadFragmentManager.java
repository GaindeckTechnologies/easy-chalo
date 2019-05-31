package com.gaindecktechnologies.easychalo.utils;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class LoadFragmentManager {

    public static void addFragment(Context context, FragmentManager fragmentManager, String className, int containerViewId) {

        Fragment fragment = fragmentManager.findFragmentByTag(className);

        if (fragment == null) {
            fragment = Fragment.instantiate(context, className);
        }
        fragmentManager.beginTransaction()
                .add(containerViewId, fragment, className)
                .commit();
    }

    public static void replaceFragment(Context context, FragmentManager fragmentManager, String className, int containerViewId) {

        Fragment fragment = fragmentManager.findFragmentByTag(className);

        if (fragment == null) {
            fragment = Fragment.instantiate(context, className);
        }
        fragmentManager.beginTransaction()
                .replace(containerViewId, fragment, className)
                .addToBackStack(className)
                .commit();
    }


}
