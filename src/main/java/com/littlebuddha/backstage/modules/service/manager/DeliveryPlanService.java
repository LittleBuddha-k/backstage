package com.littlebuddha.backstage.modules.service.manager;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.manager.DeliveryPlan;
import com.littlebuddha.backstage.modules.mapper.manager.DeliveryPlanMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class DeliveryPlanService extends CrudService<DeliveryPlan, DeliveryPlanMapper> {

    @Override
    public int save(DeliveryPlan deliveryPlan) {
        return super.save(deliveryPlan);
    }

    @Override
    public int deleteAllByPhysics(Collection<DeliveryPlan> deliveryPlan) {
        return super.deleteAllByPhysics(deliveryPlan);
    }

    @Override
    public DeliveryPlan get(DeliveryPlan deliveryPlan) {
        return super.get(deliveryPlan);
    }

    @Override
    public List<DeliveryPlan> findList(DeliveryPlan deliveryPlan) {
        return super.findList(deliveryPlan);
    }

    @Override
    public List<DeliveryPlan> findAllList(DeliveryPlan deliveryPlan) {
        return super.findAllList(deliveryPlan);
    }
}
