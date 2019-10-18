package com.netology.androidcherepanov341;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import java.util.Locale;

public class Utils {
    final static int THEME_BLACK = 0;
    final static int THEME_GREEN = 1;
    final static int THEME_BLUE = 2;

    final static String LOCAL_EN = "en";
    final static String LOCAL_RU = "ru";


    private static int sTheme = THEME_BLACK;
    private static String sLocale = LOCAL_RU;

    static void changeSettings(Activity activity, int theme, String locale) {
        sTheme = theme;
        sLocale = locale;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void onActivityCreateApplySettings(Activity activity) {
        Locale locale = new Locale(sLocale);
        Configuration config = new Configuration();

        config.setLocale(locale);
        activity.getResources().updateConfiguration(config,activity.getBaseContext().getResources()
                .getDisplayMetrics());

        switch (sTheme) {

            case THEME_BLACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;

            default:
                break;
        }
    }
}
