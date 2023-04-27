package com.gbd.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbd.forum.entity.Menu;

import java.util.List;


/**
 * 菜单表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-27 01:10:53
 */
// 操作菜单表的Mapper接口
public interface MenuMapper extends BaseMapper<Menu> {

    // 查询某一个用户的权限信息
    public abstract List<String> findUserMenuById(Long userId) ;

}

