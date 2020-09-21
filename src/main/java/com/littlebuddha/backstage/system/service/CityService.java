package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.City;
import com.littlebuddha.backstage.system.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
 * 城市业务层
 */
@Service
public class CityService extends CrudService<City, CityMapper> {
}
