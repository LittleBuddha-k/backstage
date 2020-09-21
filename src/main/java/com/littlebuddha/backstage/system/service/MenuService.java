package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.Menu;
import com.littlebuddha.backstage.system.mapper.MenuMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CrudService<Menu, MenuMapper> {
}
