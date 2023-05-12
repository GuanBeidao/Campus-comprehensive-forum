package com.gbd.forum.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Date: 2023/5/6 19:16
 * Author: GuanBD
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    //帖子id@TableId
    private Long id;

    //标题
    private String title;
    //内容
    private String content;
    //图片地址
    private String picUrls;
    //浏览量
    private Integer viewCount;
    //评论数量
    private Integer replyCount;
    //收藏
    private Integer likeCount;
    //学校id
    private Long schoolId;
    //学校id
    private Long partId;
    //创建时间
    private Date createTime;
}
