package com.springboot.servie;

import org.springframework.web.multipart.MultipartFile;

public interface ForwardService {
    Integer insertForward(MultipartFile multipartFile);
}