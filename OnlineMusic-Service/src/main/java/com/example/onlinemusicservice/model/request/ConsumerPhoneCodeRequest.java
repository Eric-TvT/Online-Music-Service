package com.example.onlinemusicservice.model.request;

import lombok.Data;

@Data
public class ConsumerPhoneCodeRequest {
    private String phoneNum;
    private String checkCode;
}
