package com.gbd.forum.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/4/16 20:26
 * Author: GuanBD
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

    //学校id
    private Long id;

    //学校名称
    private String schoolName;

}
