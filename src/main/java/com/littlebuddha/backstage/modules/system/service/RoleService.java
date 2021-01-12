package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.Role;
import com.littlebuddha.backstage.modules.system.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CrudService<Role, RoleMapper> {
}
