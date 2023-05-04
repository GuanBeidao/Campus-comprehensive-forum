package com.gbd.forum.controller;

import com.gbd.forum.service.OSSService;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2023/4/15 19:57
 * Author: GuanBD
 * Description:
 */

@RestController
@RequestMapping("oss")
public class OssController {

    @Autowired
    private OSSService ossService;

    @PostMapping("/upload")
    public ResponseResult uploadFile(MultipartFile file) throws IOException {
        String url = ossService.uploadFile(file);
        return ResponseResult.okResult(url);
    }

    @PostMapping(value = "/uploads", headers = "content-type=multipart/form-data")
    public ResponseResult upload(MultipartRequest request, Integer num) throws Exception {
        List<String> urlList = new ArrayList<>();
        for (int i =0;i<num;i++){
            MultipartFile file = request.getFile("img" + i);
            String url = ossService.uploadFile(file);
            urlList.add(url);
        }
        return ResponseResult.okResult(urlList);
    }

}
