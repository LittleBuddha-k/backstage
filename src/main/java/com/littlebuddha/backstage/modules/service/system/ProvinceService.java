package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Province;
import com.littlebuddha.backstage.modules.mapper.system.ProvinceMapper;
import org.springframework.stereotype.Service;

/**
 * 区域业务层
 */
@Service
public class ProvinceService extends CrudService<Province, ProvinceMapper> {
}
