package com.littlebuddha.backstage.modules.service.system;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.system.Department;
import com.littlebuddha.backstage.modules.mapper.system.DepartmentMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门业务层
 */
@Service
public class DepartmentService extends CrudService<Department, DepartmentMapper> {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department get(Department department) {
        return super.get(department);
    }

    public Department findByParentId(Department department) {
        Department departments = departmentMapper.get(department);
        return departments;
    }

    @Override
    public List<Department> findList(Department entity) {
        return super.findList(entity);
    }

    @Override
    public List<Department> findAllList(Department department) {
        List<Department> allList = super.findAllList(department);
        return allList;
    }

    @Override
    public int save(Department department) {
        if(StringUtils.isBlank(department.getParentId())){
            department.setParentId("-1");
            department.setParentIds("-1");
        }

        if(StringUtils.isNotBlank(department.getId())){
            Department parentDepartment = departmentMapper.get(department.getId());
            department.setParentId(parentDepartment.getId());
            department.setParentIds(parentDepartment.getParentIds() + "," + parentDepartment.getId());
        }

        super.save(department);
        return 0;
    }

    @Override
    public int deleteByPhysics(Department entity) {
        return super.deleteByPhysics(entity);
    }

    @Override
    public int deleteByLogic(Department entity) {
        return super.deleteByLogic(entity);
    }

    public Department findTheBiggestDepartment() {
        Department department = new Department();
        List<Department> allList = departmentMapper.findAllList(new Department());
        for (Department entity : allList) {
            if (entity.getParentId().equals("0")) {
                department = entity;
                break;
            }
        }
        return department;
    }

    /*部门数据树形结构数据排序
    @param sourceList 数据源集合
    @param targetList 排序后的集合
    @param parentId 当前的父级类目 ID
    */
    /*public List<Department> sortDepartmentList(List<Department> sourceList, List<Department> targetList, String parentId) {
        List<Department> childrenList = null;
        for (Department source : sourceList) {
            if (source.getParentId().equals(parentId)) {
                targetList.add(source);
                // 判断有没有子节点，有则继续追加
                List<Department> departments = findByParentId(source);
                if (departments != null && departments.size() > 0) {
                    childrenList = new ArrayList<>();
                    //找子节点
                    for (Department tbContentCategory : sourceList) {
                        if (tbContentCategory.getParentId().equals(source.getId())) {
                            sortDepartmentList(sourceList, targetList, source.getId());
                            break;
                        }
                    }
                    source.setChildrenList(childrenList);
                }
            }
        }
        return targetList;
    }*/
}
