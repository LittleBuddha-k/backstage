package com.littlebuddha.backstage.system.mapper;

import com.littlebuddha.backstage.common.base.BaseMapper;
import com.littlebuddha.backstage.system.entity.Menu;
import com.littlebuddha.backstage.system.entity.Operator;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> findPermissionsByOperator(Operator operator);
}
