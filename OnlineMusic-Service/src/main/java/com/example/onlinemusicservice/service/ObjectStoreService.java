package com.example.onlinemusicservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ObjectStoreService {
    public String uploadFile(String dirName, String objectName, MultipartFile file) throws IOException;
}

