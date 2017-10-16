package com.piotrskalski;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validate(String pattern, String line){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(line);
        return matcher.matches();
    }
}
