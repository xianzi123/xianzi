package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.park.mapper.AInformationMapper;
import com.park.model.AInformation;
import com.park.service.AInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-09 0:11
 */
@Service
public class AInformationServiceImpl implements AInformationService {
    @Autowired
    private AInformationMapper aim;
    @Override
    public AInformation selectById(int aInformationId) {

        return aim.selectById(aInformationId);
    }

    @Override
    public List<AInformation> selectAllAInformation() {

        return aim.selectList(null);
    }

    @Override
    public int insert(AInformation a) {

        return aim.insert(a);
    }

    @Override
    public int delete(int id) {

        return aim.deleteById(id);
    }
    @Override
    public List<AInformation> selectAll() {
        return aim.selectList(null);
    }

    @Override
    public String selectByIdU(int aid) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("a_information_id",aid);
        return aim.selectOne(qw).getAContent();
    }
}
