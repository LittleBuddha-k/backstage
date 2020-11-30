package com.littlebuddha.backstage.system.mapper;

import com.littlebuddha.backstage.common.base.BaseMapper;
import com.littlebuddha.backstage.system.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> findByParentId(Department department);

    /**
     * 通过传值parentId,查询id为parent的数据
     * @param department
     * @return
     */
    Department getByParentIdAndName(Department department);
}
