package com.coviam.internalapp.hrms.InterLocalization;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by khan on 1/27/17.
 */
public class MessageConverter {
    @Autowired
    private static ResourceBundle resourceBundle;
    public static String getString(String message,String language){
        Locale locale=new Locale.Builder().setLanguage(language).build();
        resourceBundle=ResourceBundle.getBundle("message",locale);
        return resourceBundle.getString(message);
    }
}
