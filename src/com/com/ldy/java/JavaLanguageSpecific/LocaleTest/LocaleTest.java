package com.ldy.java.JavaLanguageSpecific.LocaleTest;

import java.util.Locale;

/**
 * Created by liudeyu on 2017/9/7.
 */
public class LocaleTest {
    public static void main(String[] argv) {
        Locale english = Locale.ENGLISH;
        Locale chinese = Locale.CHINESE;
        int index = 0;
//        displaySupportLocale();
//        Locale Indonesian = new Locale("ind", "IDN");
//        displayLocale(Indonesian);
//        Locale indiaLanuage = new Locale("hin", "IND");
//        for(Locale locale:Locale.getAvailableLocales()){
//            displayLocale(locale);
//        }
        for (Locale locale : Locale.getAvailableLocales()) {
            System.out.println(locale.getLanguage() + "-" + locale.getCountry() + " [" + locale.getDisplayName(Locale.ENGLISH) + "]");
        }


    }

    private static void displayLocale(Locale indonesian) {
        System.out.println(indonesian.getCountry() + ": " + indonesian.getDisplayName() + ": " + indonesian.getLanguage());
    }

    private static void displaySupportLocale() {
        for (Locale locale : Locale.getAvailableLocales()) {
            System.out.println(locale.getCountry() + "  " + locale.getLanguage());
        }
    }
}
