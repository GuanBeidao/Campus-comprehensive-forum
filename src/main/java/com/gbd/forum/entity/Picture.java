package com.gbd.forum.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Picture)表实体类
 *
 * @author makejava
 * @since 2023-05-03 12:06:05
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("picture")
public class Picture  {
    //图片id@TableId
    private Long id;

    //图片地址
    private String imgUrl;
    //帖子id
    private Long postId;
    //上传时间
    private Date createTime;



}

