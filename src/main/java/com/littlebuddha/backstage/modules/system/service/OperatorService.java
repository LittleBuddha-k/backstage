package com.littlebuddha.backstage.modules.system.service;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.system.entity.Operator;
import com.littlebuddha.backstage.modules.system.mapper.OperatorMapper;
import org.springframework.stereotype.Service;

@Service
public class OperatorService extends CrudService<Operator, OperatorMapper> {
}
