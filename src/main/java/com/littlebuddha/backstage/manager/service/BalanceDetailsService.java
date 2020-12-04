package com.littlebuddha.backstage.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.manager.entity.BalanceDetails;
import com.littlebuddha.backstage.manager.mapper.BalanceDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class BalanceDetailsService extends CrudService<BalanceDetails, BalanceDetailsMapper> {

    @Override
    public int save(BalanceDetails balanceDetails) {
        return super.save(balanceDetails);
    }

    @Override
    public int deleteAllByPhysics(Collection<BalanceDetails> balanceDetails) {
        return super.deleteAllByPhysics(balanceDetails);
    }

    @Override
    public BalanceDetails get(BalanceDetails balanceDetails) {
        return super.get(balanceDetails);
    }

    @Override
    public List<BalanceDetails> findList(BalanceDetails balanceDetails) {
        return super.findList(balanceDetails);
    }

    @Override
    public List<BalanceDetails> findAllList(BalanceDetails balanceDetails) {
        return super.findAllList(balanceDetails);
    }
}
