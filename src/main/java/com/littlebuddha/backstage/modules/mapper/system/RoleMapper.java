package com.littlebuddha.backstage.modules.mapper.system;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.system.Operator;
import com.littlebuddha.backstage.modules.entity.system.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Set<String> findRolesByOperator(Operator operator);
}
