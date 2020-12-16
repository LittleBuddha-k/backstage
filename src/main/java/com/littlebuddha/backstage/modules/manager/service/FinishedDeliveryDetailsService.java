package com.littlebuddha.backstage.modules.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.modules.manager.entity.FinishedDeliveryDetails;
import com.littlebuddha.backstage.modules.manager.mapper.FinishedDeliveryDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class FinishedDeliveryDetailsService extends CrudService<FinishedDeliveryDetails, FinishedDeliveryDetailsMapper> {

    @Override
    public int save(FinishedDeliveryDetails finishedDeliveryDetails) {
        return super.save(finishedDeliveryDetails);
    }

    @Override
    public int deleteAllByPhysics(Collection<FinishedDeliveryDetails> finishedDeliveryDetails) {
        return super.deleteAllByPhysics(finishedDeliveryDetails);
    }

    @Override
    public FinishedDeliveryDetails get(FinishedDeliveryDetails finishedDeliveryDetails) {
        return super.get(finishedDeliveryDetails);
    }

    @Override
    public List<FinishedDeliveryDetails> findList(FinishedDeliveryDetails finishedDeliveryDetails) {
        return super.findList(finishedDeliveryDetails);
    }

    @Override
    public List<FinishedDeliveryDetails> findAllList(FinishedDeliveryDetails finishedDeliveryDetails) {
        return super.findAllList(finishedDeliveryDetails);
    }
}