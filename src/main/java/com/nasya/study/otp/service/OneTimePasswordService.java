package com.nasya.study.otp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasya.study.otp.enitity.OneTimePassword;
import com.nasya.study.otp.helper.OneTimePasswordHelper;
import com.nasya.study.otp.repository.OneTimePasswordRepository;

@Service
public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    @Autowired
    private OneTimePasswordRepository oneTimePasswordRepository;

    public OneTimePassword createOneTimePassword() {

        OneTimePassword oneTimePassword = new OneTimePassword();
        oneTimePassword.setOneTimePasswordCode(OneTimePasswordHelper.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        OneTimePassword otp = oneTimePasswordRepository.save(oneTimePassword);

        return otp;
    }
}
