package com.example.validate.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateService {

    public String validateCreditCard(String cardNumber){
        if(isValidCreditCard(cardNumber)){
            return "Valid";
        }else {
            return "Invalid";
        }
    }

    private   boolean isValidCreditCard(String cardNumber) {
        int length = cardNumber.length();
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return (sum % 10 == 0);
    }



    public  String validateEmail(String email) {
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean isValid=matcher.matches();
        if(isValid){
            return "Valid Email";
        }else {
            return "Invalid Email";
        }
    }
}
