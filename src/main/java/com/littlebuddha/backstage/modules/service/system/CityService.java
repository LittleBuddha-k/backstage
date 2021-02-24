package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.City;
import com.littlebuddha.backstage.modules.mapper.system.CityMapper;
import org.springframework.stereotype.Service;

/**
 * 城市业务层
 */
@Service
public class CityService extends CrudService<City, CityMapper> {
}
