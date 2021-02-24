package com.littlebuddha.backstage.modules.service.manager;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.entity.manager.MaterielReturnFromManufacturer;
import com.littlebuddha.backstage.modules.mapper.manager.MaterielReturnFromManufacturerMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class MaterielReturnFromManufacturerService extends CrudService<MaterielReturnFromManufacturer, MaterielReturnFromManufacturerMapper> {

    @Override
    public int save(MaterielReturnFromManufacturer materielReturnFromManufacturer) {
        return super.save(materielReturnFromManufacturer);
    }

    @Override
    public int deleteAllByPhysics(Collection<MaterielReturnFromManufacturer> materielReturnFromManufacturer) {
        return super.deleteAllByPhysics(materielReturnFromManufacturer);
    }

    @Override
    public MaterielReturnFromManufacturer get(MaterielReturnFromManufacturer materielReturnFromManufacturer) {
        return super.get(materielReturnFromManufacturer);
    }

    @Override
    public List<MaterielReturnFromManufacturer> findList(MaterielReturnFromManufacturer materielReturnFromManufacturer) {
        return super.findList(materielReturnFromManufacturer);
    }

    @Override
    public List<MaterielReturnFromManufacturer> findAllList(MaterielReturnFromManufacturer materielReturnFromManufacturer) {
        return super.findAllList(materielReturnFromManufacturer);
    }
}
