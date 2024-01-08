package com.example.validate.controller;

import com.example.validate.service.ValidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ValidateControllerTest {

    @InjectMocks
    private ValidateController cardController;

    @Mock
    private ValidateService cardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreditCardValidate_ValidCard() {
        String validCardNumber = "4111111111111111";
        when(cardService.validateCreditCard(validCardNumber)).thenReturn("Valid");

        ResponseEntity<String> responseEntity = cardController.creditCardValidate(validCardNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Valid", responseEntity.getBody());
    }

    @Test
    public void testCreditCardValidate_InvalidCard() {
        String invalidCardNumber = "1234567890123456";
        when(cardService.validateCreditCard(invalidCardNumber)).thenReturn("Invalid");

        ResponseEntity<String> responseEntity = cardController.creditCardValidate(invalidCardNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Invalid", responseEntity.getBody());
    }

    // Add more test cases for different scenarios
    @Test
    public void testEmailValidate_ValidEmail() {
        String validEmail = "snbiju@gmail.com";
        when(cardService.validateEmail(validEmail)).thenReturn("Email Valid");

        ResponseEntity<String> responseEntity = cardController.emailValidate(validEmail);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Email Valid", responseEntity.getBody());
    }
    @Test
    public void testEmailValidate_InValidEmail() {
        String validEmail = "snbiju@gmailcom";
        when(cardService.validateEmail(validEmail)).thenReturn("Invalid Email");

        ResponseEntity<String> responseEntity = cardController.emailValidate(validEmail);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Invalid Email", responseEntity.getBody());
    }
}
