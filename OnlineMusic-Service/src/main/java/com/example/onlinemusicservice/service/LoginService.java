package com.example.onlinemusicservice.service;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.ConsumerPhoneCodeRequest;

import java.security.NoSuchAlgorithmException;

public interface LoginService {
    public R sendSmsCode(String phone) throws NoSuchAlgorithmException;


    public  R checkRCode(ConsumerPhoneCodeRequest consumerPhoneCodeRequest);
}
