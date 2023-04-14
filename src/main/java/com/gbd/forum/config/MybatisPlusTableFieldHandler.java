package com.gbd.forum.config;

/**
 * Date: 2023/4/9 23:44
 * Author: GuanBD
 * Description:
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by XuanRan on 2022/10/2
 * 当Mybatis进行数据插入和更新时执行
 */
@Slf4j
@Component
public class MybatisPlusTableFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 插入数据时执行此方法
        setFieldValByName("isDelete", 0, metaObject);
        setFieldValByName("createTime", new Date(), metaObject);
        setFieldValByName("updateTime", new Date(), metaObject);
    }

    // 更新数据时执行此方法
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
    }
}

