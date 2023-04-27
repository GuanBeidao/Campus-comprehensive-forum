package com.gbd.forum.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbd.forum.entity.LoginUser;
import com.gbd.forum.entity.User;
import com.gbd.forum.entity.dto.UserDto;
import com.gbd.forum.entity.vo.LoginVo;
import com.gbd.forum.entity.vo.RegisterVo;
import com.gbd.forum.service.UsersService;
import com.gbd.forum.utils.BeanCopyUtils;
import com.gbd.forum.utils.RedisCache;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2023-04-09 23:12:17
 */
@RestController
@RequestMapping("user")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    @Autowired
    private RedisCache redisCache;

    /*
    * 用户注册
    * */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody RegisterVo registerVo){
        usersService.register(registerVo);
        return ResponseResult.okResult();
    }

    /*
     * 用户登录
     * */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginVo loginVo){
        String token = usersService.lgoin(loginVo);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return ResponseResult.okResult(map);
    }

    /*
    * 退出登录
    * */
    @GetMapping("/logout")
    public ResponseResult logout(){
        // 获取登录的用户信息
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userId);
        ResponseResult result = new ResponseResult();
        result.setMsg("退出成功");
        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("getUserInfo")
    public ResponseResult getInfo() {
        Map<String,Object> map = usersService.getInfo();
        return ResponseResult.okResult(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        User user = this.usersService.getById(id);
        UserDto userInfo = BeanCopyUtils.copyBean(user, UserDto.class);
        return ResponseResult.okResult(userInfo);
    }


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<User> page, User user) {
//        return success(this.usersService.page(page, new QueryWrapper<>(users)));
        return null;
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody User user) {
//        return success(this.usersService.updateById(users));
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
//        return success(this.usersService.removeByIds(idList));
        return null;
    }
}

