package com.littlebuddha.backstage.datastatistics.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.datastatistics.entity.Order;
import com.littlebuddha.backstage.datastatistics.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class OrderService extends CrudService<Order, OrderMapper> {

    @Override
    public int save(Order order) {
        return super.save(order);
    }

    @Override
    public int deleteAllByPhysics(Collection<Order> orders) {
        return super.deleteAllByPhysics(orders);
    }

    @Override
    public Order get(Order order) {
        return super.get(order);
    }

    @Override
    public List<Order> findList(Order order) {
        return super.findList(order);
    }

    @Override
    public List<Order> findAllList(Order order) {
        return super.findAllList(order);
    }
}
