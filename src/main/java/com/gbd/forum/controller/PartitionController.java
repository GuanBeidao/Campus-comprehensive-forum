package com.gbd.forum.controller;

import com.gbd.forum.entity.Partition;
import com.gbd.forum.entity.dto.PartitionDto;
import com.gbd.forum.service.PartitionService;
import com.gbd.forum.utils.BeanCopyUtils;
import com.gbd.forum.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Partition)表控制层
 *
 * @author makejava
 * @since 2023-04-12 22:29:36
 */
@RestController
@RequestMapping("partition")
public class PartitionController {
    /**
     * 服务对象
     */
    @Resource
    private PartitionService partitionService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll() {
        List<Partition> list = partitionService.list();
        List<PartitionDto> partitionDtos = BeanCopyUtils.copyBeanList(list, PartitionDto.class);
        return ResponseResult.okResult(partitionDtos);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        Partition partition = partitionService.getById(id);
        return ResponseResult.okResult(partition);
    }

    /**
     * 新增数据
     *
     * @param partition 实体对象
     * @return 新增结果
     */
    @PostMapping("/addPart")
    public ResponseResult insert(@RequestBody Partition partition) {
        System.out.println(partition);
        boolean save = partitionService.save(partition);
        if (save){
            return ResponseResult.okResult();
        }else{
            return ResponseResult.errorResult(201,"添加失败");
        }
    }

    /**
     * 修改数据
     *
     * @param partition 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Partition partition) {
        boolean update = partitionService.update(partition, null);
        if (update){
            return ResponseResult.okResult();
        }else{
            return ResponseResult.errorResult(201,"修改失败");
        }
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        partitionService.removeBatchByIds(idList);
        return ResponseResult.okResult();
    }
}

