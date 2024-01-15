package com.mycompany.myapp.service;

import org.springframework.web.multipart.MultipartFile;

public class S3Service implements FileService{
    @Override
    public String uploadFile(MultipartFile file){
        //upload file to aws s3
        return null;
    }
}
