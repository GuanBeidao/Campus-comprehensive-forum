package com.gbd.forum.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Schools)表实体类
 *
 * @author makejava
 * @since 2023-04-12 22:28:58
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("schools")
public class Schools  {
    //学校id@TableId
    private Long id;

    //学校名称
    private String schoolName;
    //校徽图片
    private String schoolBadge;
    //创建时间
    private Date createTime;



}

