package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.park.mapper.PManagerMapper;
import com.park.mapper.PUserMapper;
import com.park.model.Pmanager;
import com.park.model.Puser;
import com.park.service.PManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-02 10:51
 */
@Service
public class PManagerServiceImpl implements PManagerService {
    @Autowired
    private PManagerMapper mapper;
    public Pmanager select(String uname, String password){
        QueryWrapper<Pmanager> qw = new QueryWrapper<Pmanager>();
        qw.eq("pname",uname);
        qw.eq("ppassword",password);
        Pmanager manager = mapper.selectOne(qw);
        return manager;
    }
}
