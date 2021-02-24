package com.littlebuddha.backstage.modules.mapper.manager;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.manager.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ck
 * @date 2020/12/2 10:49
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
