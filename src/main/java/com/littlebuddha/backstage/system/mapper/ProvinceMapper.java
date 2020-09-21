package com.littlebuddha.backstage.system.mapper;

import com.littlebuddha.backstage.common.base.BaseMapper;
import com.littlebuddha.backstage.system.entity.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {

    List<Province> findAll();
}
