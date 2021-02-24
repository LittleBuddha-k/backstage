package com.littlebuddha.backstage.modules.service.manager;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.manager.OtherOutWarehouse;
import com.littlebuddha.backstage.modules.mapper.manager.OtherOutWarehouseMapper;
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
