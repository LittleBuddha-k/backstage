package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.City;
import com.littlebuddha.backstage.modules.system.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
 * 城市业务层
 */
@Service
public class CityService extends CrudService<City, CityMapper> {
}
