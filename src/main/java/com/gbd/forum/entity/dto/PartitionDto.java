package com.gbd.forum.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/4/16 23:00
 * Author: GuanBD
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartitionDto {

    //板块id@TableId
    private Long id;

    //板块名称
    private String partName;

}
