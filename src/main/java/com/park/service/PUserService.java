package com.park.service;

import com.park.model.Puser;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-02 10:28
 */
public interface PUserService {
    public Puser select(String uname, String password);
    List<Puser> selectAllPUser();

    int insert(Puser p);

    int delete(int id);

    int update(Puser p);
}
