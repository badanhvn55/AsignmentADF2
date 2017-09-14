/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignmentadf2.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ueda
 */
public class Validator {

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String strEmail = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern email_pattern = Pattern.compile(strEmail, Pattern.CASE_INSENSITIVE);
        Matcher mEmail = email_pattern.matcher(inputStr);
        if (mEmail.matches()) {
            isValid = true;
        }else{
            System.err.println("Wrong email format. Please re-enter your email: ");
        }
        return isValid;
    }

    public static boolean isPhoneValid(String phone) {
        boolean isValid = false;
        String strPhone = "(\\+84|0)\\d{9,10}";
        CharSequence inputStr = phone;
        Pattern phone_pattern = Pattern.compile(strPhone, Pattern.CASE_INSENSITIVE);
        Matcher mPhone = phone_pattern.matcher(inputStr);
        if (mPhone.matches()) {
            isValid = true;
        }else{
            System.err.println("Wrong phone format. Please re-enter your phone number: ");
        }
        return isValid;
    }

    
}
