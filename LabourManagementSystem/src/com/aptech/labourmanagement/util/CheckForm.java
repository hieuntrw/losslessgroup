/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Noi Nho
 */
public class CheckForm {

    /**
     * check is munber
     * @param value
     * @return true or false
     */
    public static boolean isNumberic(String value) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * check phone number
     * @param value
     * @return true or false
     */
    public static boolean checkPhoneNumber(String value) {
        Pattern pattern = Pattern.compile("[0-9]{10,11}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }  
}
