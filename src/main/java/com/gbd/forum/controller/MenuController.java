package com.gbd.forum.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbd.forum.entity.Menu;
import com.gbd.forum.service.MenuService;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单表(Menu)表控制层
 *
 * @author makejava
 * @since 2023-04-27 01:10:53
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Menu> page, Menu menu) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param menu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Menu menu) {
        return null;
    }

    /**
     * 修改数据
     *
     * @param menu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Menu menu) {
        return null;
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return null;
    }
}

