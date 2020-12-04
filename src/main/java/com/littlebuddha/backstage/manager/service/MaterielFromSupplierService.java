package com.littlebuddha.backstage.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.manager.entity.MaterielFromSupplier;
import com.littlebuddha.backstage.manager.mapper.MaterielFromSupplierMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class MaterielFromSupplierService extends CrudService<MaterielFromSupplier, MaterielFromSupplierMapper> {

    @Override
    public int save(MaterielFromSupplier materielFromSupplier) {
        return super.save(materielFromSupplier);
    }

    @Override
    public int deleteAllByPhysics(Collection<MaterielFromSupplier> materielFromSupplier) {
        return super.deleteAllByPhysics(materielFromSupplier);
    }

    @Override
    public MaterielFromSupplier get(MaterielFromSupplier materielFromSupplier) {
        return super.get(materielFromSupplier);
    }

    @Override
    public List<MaterielFromSupplier> findList(MaterielFromSupplier materielFromSupplier) {
        return super.findList(materielFromSupplier);
    }

    @Override
    public List<MaterielFromSupplier> findAllList(MaterielFromSupplier materielFromSupplier) {
        return super.findAllList(materielFromSupplier);
    }
}
