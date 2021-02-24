package com.littlebuddha.backstage.modules.mapper.system;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.system.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {

    List<Province> findAll();
}
