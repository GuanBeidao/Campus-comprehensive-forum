package com.gbd.forum.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.gbd.forum.enums.HttpCodeEnum;
import com.gbd.forum.exception.SystemException;
import com.gbd.forum.service.OSSService;
import com.gbd.forum.utils.PathUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Data
@ConfigurationProperties(prefix = "oss")
public class OSSServiceImpl implements OSSService {
    @Override
    public String uploadFile(MultipartFile img) throws IOException {
        //判断文件类型
        //获取原始文件名
        String originalFilename = img.getOriginalFilename();

        //对原始文件名进行判断
        boolean flag = false;
        if(originalFilename.endsWith(".png")){
            flag = true;
        }

        if(originalFilename.endsWith(".jpg")){
            flag = true;
        }

        if(!flag){
            throw new SystemException(HttpCodeEnum.FILE_TYPE_ERROR);
        }

        //如果判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadFile(filePath,img.getInputStream());

        return url;
    }

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;


    private String uploadFile(String filePath, InputStream inputStream) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, inputStream);

        // 上传字符串。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return "https://"+bucketName+"."+endpoint+"/"+filePath;
    }
}
