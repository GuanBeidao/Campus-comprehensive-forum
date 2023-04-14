package com.gbd.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gbd.forum.entity.Partition;
import com.gbd.forum.mapper.PartitionMapper;
import com.gbd.forum.service.PartitionService;
import org.springframework.stereotype.Service;

/**
 * (Partition)表服务实现类
 *
 * @author makejava
 * @since 2023-04-12 22:29:36
 */
@Service("partitionService")
public class PartitionServiceImpl extends ServiceImpl<PartitionMapper, Partition> implements PartitionService {

}

