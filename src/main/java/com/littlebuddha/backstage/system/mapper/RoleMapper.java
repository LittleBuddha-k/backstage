package com.littlebuddha.backstage.system.mapper;

import com.littlebuddha.backstage.common.base.BaseMapper;
import com.littlebuddha.backstage.system.entity.Operator;
import com.littlebuddha.backstage.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Set<String> findRolesByOperator(Operator operator);
}
