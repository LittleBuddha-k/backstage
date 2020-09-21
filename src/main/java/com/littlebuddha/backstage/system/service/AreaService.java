package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.Area;
import com.littlebuddha.backstage.system.mapper.AreaMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class AreaService extends CrudService<Area, AreaMapper> {
}
