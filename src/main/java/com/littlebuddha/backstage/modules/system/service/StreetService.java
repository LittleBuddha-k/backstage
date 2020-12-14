package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.Street;
import com.littlebuddha.backstage.modules.system.mapper.StreetMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class StreetService extends CrudService<Street, StreetMapper> {
}
