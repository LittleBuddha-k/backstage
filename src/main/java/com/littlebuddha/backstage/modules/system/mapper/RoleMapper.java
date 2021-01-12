package com.littlebuddha.backstage.modules.system.mapper;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.system.entity.Operator;
import com.littlebuddha.backstage.modules.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Set<String> findRolesByOperator(Operator operator);
}
