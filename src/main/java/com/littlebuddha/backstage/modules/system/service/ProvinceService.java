package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.Province;
import com.littlebuddha.backstage.modules.system.mapper.ProvinceMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class ProvinceService extends CrudService<Province, ProvinceMapper> {
}
