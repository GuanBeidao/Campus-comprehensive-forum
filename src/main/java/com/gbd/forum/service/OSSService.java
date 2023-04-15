package com.gbd.forum.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Date: 2023/4/15 21:13
 * Author: GuanBD
 * Description:
 */

public interface OSSService {


    String uploadFile(MultipartFile file) throws IOException;
}
