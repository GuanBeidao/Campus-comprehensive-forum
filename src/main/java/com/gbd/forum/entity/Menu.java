package com.gbd.forum.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 菜单表(Menu)表实体类
 *
 * @author makejava
 * @since 2023-04-27 01:10:53
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class Menu  {
    @TableId
    private Long id;

    //菜单名
    private String menuName;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //是否删除（0未删除 1已删除）
    private Integer isDelete;
    //备注
    private String remark;



}

