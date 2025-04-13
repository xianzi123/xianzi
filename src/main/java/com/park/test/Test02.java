package com.park.test;

import com.park.controller.PUserController;
import com.park.model.Puser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hxy
 * @create 2024-4-07 10:03
 */

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test02 {
    @Autowired
    private PUserController pc;
    //测试查询用户
    @Test
    public void test01(){
        System.out.println(pc.select());
    }
    //测试增加用户
    @Test
    public void test02(){
        Puser p = new Puser();
        p.setUname("hxy");
        p.setUphone("123456789");
        p.setPlatePhone("123456789");
        p.setSex("男");
        System.out.println(pc.addUser(p));
    }
}
