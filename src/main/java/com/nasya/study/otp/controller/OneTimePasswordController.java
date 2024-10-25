package com.nasya.study.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nasya.study.otp.service.OneTimePasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class OneTimePasswordController {

    @Autowired
    private OneTimePasswordService oneTimePasswordService;

    @GetMapping(path = "/api/v1/otp/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private Object getOTP() {
        try {
            return ResponseEntity.ok(oneTimePasswordService.createOneTimePassword());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

}
