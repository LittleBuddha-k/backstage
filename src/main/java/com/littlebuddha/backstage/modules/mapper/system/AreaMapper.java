package com.littlebuddha.backstage.modules.mapper.system;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.system.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper extends BaseMapper<Area> {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Select("SELECT * FROM system_area")
    public List<Area> findAll(Area area);
}
