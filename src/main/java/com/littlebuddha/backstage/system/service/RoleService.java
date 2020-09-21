package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.Role;
import com.littlebuddha.backstage.system.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CrudService<Role, RoleMapper> {
}
