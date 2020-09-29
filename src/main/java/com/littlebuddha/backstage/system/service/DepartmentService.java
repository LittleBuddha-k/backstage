package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.Department;
import com.littlebuddha.backstage.system.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门业务层
 */
@Service
public class DepartmentService extends CrudService<Department, DepartmentMapper> {

    @Override
    public List<Department> findAllList(Department entity) {
        return super.findAllList(entity);
    }
}
