package com.littlebuddha.backstage.modules.system.mapper;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.system.entity.Menu;
import com.littlebuddha.backstage.modules.system.entity.Operator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    Set<String> findPermissionsByOperator(Operator operator);

    List<Menu> findByParentId(Menu menu);
}
