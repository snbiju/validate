package com.example.validate.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidateServiceTest {

    @Test
    public void testValidateCreditCard_ValidCard() {
        ValidateService validateService = new ValidateService();
        String validCardNumber = "4111111111111111";
        String result = validateService.validateCreditCard(validCardNumber);
        assertEquals("Valid", result);
    }

    @Test
    public void testValidateCreditCard_InvalidCard() {
        ValidateService validateService = new ValidateService();
        String invalidCardNumber = "1234567890123456";
        String result = validateService.validateCreditCard(invalidCardNumber);
        assertEquals("Invalid", result);
    }
    @Test
    public void testValidateEmail_ValidEmail() {
        ValidateService cardService = new ValidateService();
        String email = "snbiju@gmail.com";
        String result = cardService.validateEmail(email);
        assertEquals("Valid Email", result);
    }

    @Test
    public void testValidateEmail_InvalidEmail() {
        ValidateService validateService = new ValidateService();
        String email = "snbiju@gmailcom";
        String result = validateService.validateEmail(email);
        assertEquals("Invalid Email", result);
    }



    // Add more test cases for different scenarios
}
