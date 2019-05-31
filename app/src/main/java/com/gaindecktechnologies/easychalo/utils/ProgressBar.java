package com.gaindecktechnologies.easychalo.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

public class ProgressBar {

    private static Dialog progress;

    public static void setProgressBar(Activity activity, String message) {

        progress = new ProgressDialog(activity);
        ((ProgressDialog) progress).setMessage(message);
        ((ProgressDialog) progress).setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();

    }

    public static void dismissProgress() {
        progress.dismiss();
    }
}
