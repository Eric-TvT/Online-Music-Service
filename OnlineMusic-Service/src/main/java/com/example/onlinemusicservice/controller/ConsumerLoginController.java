package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.ConsumerPhoneCodeRequest;
import com.example.onlinemusicservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

/**
 * 短信验证登录、微信扫码、支付宝扫码、人脸识别接口api
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConsumerLoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 发送验证码
     *
     * @param phone
     */
    @GetMapping("/sms")
    public R sendSmsCode(@RequestParam String phone) throws NoSuchAlgorithmException {
        return loginService.sendSmsCode(phone);
    }


    /**
     * 校验验证码6
     *
     * @param codeRequest
     * @return
     */
    @PostMapping("/sms/code")
    public R checkSmsCode(@RequestBody ConsumerPhoneCodeRequest codeRequest) {
        return loginService.checkRCode(codeRequest);
    }
}
