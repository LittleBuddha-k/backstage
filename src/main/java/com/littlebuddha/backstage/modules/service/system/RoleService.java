package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Role;
import com.littlebuddha.backstage.modules.mapper.system.RoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CrudService<Role, RoleMapper> {
}
