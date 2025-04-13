package com.park.service.impl;

import com.park.mapper.RegisterMapper;
import com.park.model.Puser;
import com.park.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hxy
 * @create 2024-4-02 11:03
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper rm;

    @Override
    public int register(Puser p) {

        return rm.insertUser(p);
    }
    @Override
    public int insert(Puser p) {

        return rm.insert(p);
    }
}
