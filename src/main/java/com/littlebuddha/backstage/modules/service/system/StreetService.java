package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Street;
import com.littlebuddha.backstage.modules.mapper.system.StreetMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class StreetService extends CrudService<Street, StreetMapper> {
}
