package com.littlebuddha.backstage.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.manager.entity.MaterialReturnFromManufacturer;
import com.littlebuddha.backstage.manager.entity.OtherOutWarehouse;
import com.littlebuddha.backstage.manager.mapper.MaterielReturnFromManufacturerMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class MaterielReturnFromManufacturerService extends CrudService<MaterialReturnFromManufacturer, MaterielReturnFromManufacturerMapper> {

    @Override
    public int save(MaterialReturnFromManufacturer materialReturnFromManufacturer) {
        return super.save(materialReturnFromManufacturer);
    }

    @Override
    public int deleteAllByPhysics(Collection<MaterialReturnFromManufacturer> materialReturnFromManufacturer) {
        return super.deleteAllByPhysics(materialReturnFromManufacturer);
    }

    @Override
    public MaterialReturnFromManufacturer get(MaterialReturnFromManufacturer materialReturnFromManufacturer) {
        return super.get(materialReturnFromManufacturer);
    }

    @Override
    public List<MaterialReturnFromManufacturer> findList(MaterialReturnFromManufacturer materialReturnFromManufacturer) {
        return super.findList(materialReturnFromManufacturer);
    }

    @Override
    public List<MaterialReturnFromManufacturer> findAllList(MaterialReturnFromManufacturer materialReturnFromManufacturer) {
        return super.findAllList(materialReturnFromManufacturer);
    }
}
