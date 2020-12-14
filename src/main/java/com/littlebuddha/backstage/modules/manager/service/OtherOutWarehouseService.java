package com.littlebuddha.backstage.modules.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.modules.manager.entity.OtherOutWarehouse;
import com.littlebuddha.backstage.modules.manager.mapper.OtherOutWarehouseMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class OtherOutWarehouseService extends CrudService<OtherOutWarehouse, OtherOutWarehouseMapper> {

    @Override
    public int save(OtherOutWarehouse otherOutWarehouse) {
        return super.save(otherOutWarehouse);
    }

    @Override
    public int deleteAllByPhysics(Collection<OtherOutWarehouse> otherOutWarehouse) {
        return super.deleteAllByPhysics(otherOutWarehouse);
    }

    @Override
    public OtherOutWarehouse get(OtherOutWarehouse otherOutWarehouse) {
        return super.get(otherOutWarehouse);
    }

    @Override
    public List<OtherOutWarehouse> findList(OtherOutWarehouse otherOutWarehouse) {
        return super.findList(otherOutWarehouse);
    }

    @Override
    public List<OtherOutWarehouse> findAllList(OtherOutWarehouse otherOutWarehouse) {
        return super.findAllList(otherOutWarehouse);
    }
}
