package com.littlebuddha.backstage.manager.service;

import com.littlebuddha.backstage.common.base.CrudService;
import com.littlebuddha.backstage.manager.entity.SummaryConsiderBomDetails;
import com.littlebuddha.backstage.manager.mapper.SummaryConsiderBomDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author ck
 * @date 2020/12/2 10:52
 */
@Service
public class SummaryConsiderBomDetailsService extends CrudService<SummaryConsiderBomDetails, SummaryConsiderBomDetailsMapper> {

    @Override
    public int save(SummaryConsiderBomDetails summaryConsiderBomDetails) {
        return super.save(summaryConsiderBomDetails);
    }

    @Override
    public int deleteAllByPhysics(Collection<SummaryConsiderBomDetails> summaryConsiderBomDetails) {
        return super.deleteAllByPhysics(summaryConsiderBomDetails);
    }

    @Override
    public SummaryConsiderBomDetails get(SummaryConsiderBomDetails summaryConsiderBomDetails) {
        return super.get(summaryConsiderBomDetails);
    }

    @Override
    public List<SummaryConsiderBomDetails> findList(SummaryConsiderBomDetails summaryConsiderBomDetails) {
        return super.findList(summaryConsiderBomDetails);
    }

    @Override
    public List<SummaryConsiderBomDetails> findAllList(SummaryConsiderBomDetails summaryConsiderBomDetails) {
        return super.findAllList(summaryConsiderBomDetails);
    }
}
