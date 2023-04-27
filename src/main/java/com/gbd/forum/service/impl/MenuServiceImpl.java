package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Menu;
import com.gbd.forum.mapper.MenuMapper;
import com.gbd.forum.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2023-04-27 01:10:53
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}

