package com.littlebuddha.backstage.system.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.system.entity.Department;
import com.littlebuddha.backstage.system.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Department> findByParentId(Department department){
        List<Department> departments = departmentMapper.findByParentId(department);
        return departments;
    }

    @Override
    public List<Department> findList(Department entity) {
        return super.findList(entity);
    }

    @Override
    public List<Department> findAllList(Department department) {
        Department theBiggestDepartment = findTheBiggestDepartment();
        List<Department> allList = super.findAllList(department);
        //List afterSort = sortDepartmentList(allList, new ArrayList(), theBiggestDepartment.getId());
        /*TreeDataUtil.setDepartmentChildrenList(allList);*/
        return allList;
    }

    @Override
    public int save(Department entity) {
        return super.save(entity);
    }

    @Override
    public int deleteByPhysics(Department entity) {
        return super.deleteByPhysics(entity);
    }

    @Override
    public int deleteByLogic(Department entity) {
        return super.deleteByLogic(entity);
    }

    public Department findTheBiggestDepartment(){
        Department department = new Department();
        List<Department> allList = departmentMapper.findAllList(new Department());
        for (Department entity : allList) {
            if (entity.getParentId().equals("0")){
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
    public List<Department> sortDepartmentList(List<Department> sourceList, List<Department> targetList, String parentId) {
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
    }
}
