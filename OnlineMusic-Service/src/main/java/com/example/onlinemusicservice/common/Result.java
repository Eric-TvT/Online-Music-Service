package com.example.onlinemusicservice.common;

import lombok.Data;

@Data
public class Result<T> {
  String authorization;
  Object obj;
}
