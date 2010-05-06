/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.labourmanagement.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JONNY
 */
public class PassEncryption {

    public String encryptPass(String pass) {
        byte[] hash;
        String strTemp = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(pass.getBytes());
            for (int i = 0; i < hash.length; i++) {
                strTemp += Byte.toString(hash[i]);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PassEncryption.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return strTemp;
    }
}
