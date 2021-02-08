package com.littlebuddha.backstage.modules.luckyLottery.service;

import com.littlebuddha.backstage.modules.base.CrudService;
import com.littlebuddha.backstage.modules.luckyLottery.entity.TwoColorBall;
import com.littlebuddha.backstage.modules.luckyLottery.mapper.TwoColorBallMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ck
 * @date 2021/1/13 10:46
 */
@Service
public class TwoColorBallService extends CrudService<TwoColorBall, TwoColorBallMapper> {

    @Override
    public int save(TwoColorBall entity) {
        return super.save(entity);
    }

    @Override
    public TwoColorBall get(TwoColorBall entity) {
        return super.get(entity);
    }

    @Override
    public List<TwoColorBall> findList(TwoColorBall entity) {
        return super.findList(entity);
    }

    @Override
    public List<TwoColorBall> findAllList(TwoColorBall entity) {
        return super.findAllList(entity);
    }
}
