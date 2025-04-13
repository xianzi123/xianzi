package com.park.service;

import com.park.model.Pmanager;
import com.park.model.Puser;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-02 10:52
 */
public interface PManagerService {
    public Pmanager select(String uname, String password);
}
