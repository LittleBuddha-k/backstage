package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.Area;
import com.littlebuddha.backstage.modules.system.mapper.AreaMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class AreaService extends CrudService<Area, AreaMapper> {
}
