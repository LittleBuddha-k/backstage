package com.littlebuddha.backstage.datastatistics.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.datastatistics.entity.Materiel;
import com.littlebuddha.backstage.datastatistics.mapper.MaterielMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class MaterielService extends CrudService<Materiel, MaterielMapper> {

    @Override
    public int save(Materiel entity) {
        return super.save(entity);
    }

    @Override
    public int deleteAllByPhysics(Collection<Materiel> entities) {
        return super.deleteAllByPhysics(entities);
    }

    @Override
    public Materiel get(Materiel entity) {
        return super.get(entity);
    }

    @Override
    public List<Materiel> findList(Materiel entity) {
        return super.findList(entity);
    }

    @Override
    public List<Materiel> findAllList(Materiel entity) {
        return super.findAllList(entity);
    }
}
