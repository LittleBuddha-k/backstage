package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Area;
import com.littlebuddha.backstage.modules.mapper.system.AreaMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class AreaService extends CrudService<Area, AreaMapper> {
}
