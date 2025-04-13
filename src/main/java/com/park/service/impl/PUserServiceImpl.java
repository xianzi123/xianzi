package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.park.mapper.PUserMapper;
import com.park.model.Puser;
import com.park.service.PUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-02 10:30
 */
@Service
public class PUserServiceImpl implements PUserService {
    @Autowired
    private PUserMapper mapper;
    public Puser select(String uname, String password){
        QueryWrapper<Puser> qw = new QueryWrapper<Puser>();
        qw.eq("uname",uname);
        qw.eq("upassword",password);
        Puser user = mapper.selectOne(qw);
        return user;
    }
    public List<Puser> selectAllPUser(){
        return mapper.selectList(null);
    }
    //添加用户
    @Override
    public int insert(Puser p) {
        return mapper.insert(p);
    }
    //删除用户
    @Override
    public int delete(int uid) {
        return mapper.deleteById(uid);
    }

    @Override
    public int update(Puser p) {
        //返回更新函数
        UpdateWrapper<Puser> uw = new UpdateWrapper<>();
        uw.set("uname",p.getUname());
        uw.set("uphone",p.getUphone());

        uw.set("sex",p.getSex());
        uw.set("plate_phone",p.getPlatePhone());
        uw.eq("uid",p.getUid());
        if(mapper.update(p,uw)>0){
            return 1;
        }
        return 0;
    }
}
