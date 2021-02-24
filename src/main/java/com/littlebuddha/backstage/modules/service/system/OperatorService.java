package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Operator;
import com.littlebuddha.backstage.modules.mapper.system.OperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService extends CrudService<Operator, OperatorMapper> {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public int save(Operator entity) {
        return super.save(entity);
    }

    @Override
    public Operator get(Operator entity) {
        return super.get(entity);
    }

    @Override
    public List<Operator> findList(Operator entity) {
        return super.findList(entity);
    }

    @Override
    public List<Operator> findAllList(Operator entity) {
        return super.findAllList(entity);
    }
}
