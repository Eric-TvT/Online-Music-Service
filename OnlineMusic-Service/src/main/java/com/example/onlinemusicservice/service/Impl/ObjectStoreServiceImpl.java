package com.example.onlinemusicservice.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import com.example.onlinemusicservice.service.ObjectStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
/**
 * Oss 相关业务实现类
 *
 * @author yaojianfeng
 */
@Service
public class ObjectStoreServiceImpl implements ObjectStoreService {
    @Autowired
    private OSS ossClient;
    @Value("${aliyun.oss.bucketName}")
    private String BUCKET_NAME;
    @Value("${aliyun.oss.endPoint}")
    private String ENDPOINT;
    @Override
    public String uploadFile(String dirName, String objectName, MultipartFile
            file) throws IOException {
        String fullObjectName = dirName + "/" + objectName;
        PutObjectResult result = ossClient.putObject(BUCKET_NAME, fullObjectName,
                file.getInputStream());
        return getAccessibleUrl(result.getETag(), fullObjectName);
    }
    private String getAccessibleUrl(String eTag, String objectName) {
        return "https://" + BUCKET_NAME + "." + ENDPOINT + "/" + objectName;
    }
}
