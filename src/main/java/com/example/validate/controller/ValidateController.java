package com.example.validate.controller;

import com.example.validate.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateController {

    @Autowired
    ValidateService service;
    @GetMapping("/card/number/{number}")
    public ResponseEntity<String> creditCardValidate(@PathVariable ("number") String card) {
        String status = service.validateCreditCard(card);
        return ResponseEntity.ok(status);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<String> emailValidate(@PathVariable ("email") String email) {
        String status = service.validateEmail(email);
        return ResponseEntity.ok(status);
    }
}
