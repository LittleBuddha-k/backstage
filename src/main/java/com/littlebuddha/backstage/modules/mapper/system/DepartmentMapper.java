package com.littlebuddha.backstage.modules.mapper.system;

import com.littlebuddha.backstage.modules.base.BaseMapper;
import com.littlebuddha.backstage.modules.entity.system.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 通过parentId、name获取部门信息
     * @param department
     * @return
     */
    Department findByParentIdAndName(Department department);

    /**
     * 通过parentId查询id=parentId的部门信息
     * @param department
     * @return
     */
    List<Department> findByParentId(Department department);
}
