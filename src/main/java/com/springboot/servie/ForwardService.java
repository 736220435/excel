package com.springboot.servie;

import com.springboot.entity.Forward;
import org.springframework.web.multipart.MultipartFile;

public interface ForwardService {
    Integer insertForward(MultipartFile multipartFile);
}