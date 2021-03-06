package com.littlebuddha.backstage.modules.mapper.manager;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.manager.DeliveryPlan;
import org.apache.ibatis.annotations.Mapper;

/**
 * lite and plus交货计划
 * @author ck
 * @date 2020/12/2 10:49
 */
@Mapper
public interface DeliveryPlanMapper extends BaseMapper<DeliveryPlan> {
}
