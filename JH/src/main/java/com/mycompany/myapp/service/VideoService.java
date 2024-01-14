package com.mycompany.myapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {

    public void uploadVideo(MultipartFile file){
        //upload video to aws s3
    }
}
