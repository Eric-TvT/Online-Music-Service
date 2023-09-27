package com.example.onlinemusicservice.model.domain;

import lombok.Data;

@Data
public class Token<T> {
    String authorization;
    Object obj;
}
