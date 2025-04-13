package com.park.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.park.mapper.PManagerMapper;
import com.park.mapper.PUserMapper;
import com.park.mapper.UserMapper;
import com.park.model.ParkingUsers;
import com.park.model.Pmanager;
import com.park.model.Puser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-01 13:03
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test01 {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private PUserMapper umapper;
    @Autowired
    private PManagerMapper mmapper;
    @Test
    public void test01() {
//        QueryWrapper<ParkingUsers> qw = new QueryWrapper<>();
//        qw.eq("pusers_id",1001);
        List<ParkingUsers> list2 = mapper.selectAll();
//        List<ParkingUsers> list =  mapper.selectList(null);
//        ParkingUsers pu = mapper.selectByUserId(1001);
//        System.out.println(pu);
//        System.out.println(list);
        System.out.println(list2);
    }
    @Test
    public void test02() {
        QueryWrapper<ParkingUsers> qw = new QueryWrapper<ParkingUsers>();
        qw.like("user_name","黄");
        List<ParkingUsers> list = mapper.selectList(qw);
//        ParkingUsers hyx = mapper.selectByUserName("黄修源");
        System.out.println(list);
    }
//    @Test
//    public void test03() {
//        mapper.insert(new ParkingUsers(1002,"王明霖","辽A10086",null,1002));
//    }
    @Test
    public void test04() {
        ParkingUsers parkingUsers = mapper.selectById(1002);
        System.out.println(parkingUsers);

    }
    @Test
    public void test05() {
        ParkingUsers parkingUsers = mapper.selectByUserId(1001);
        System.out.println(parkingUsers);
    }
    @Test
    public void test06() {
        ParkingUsers parkingUsers = mapper.selectByPlateNumber("辽A0JJ75");

        System.out.println(mapper.selectByPlateNumber("辽A0JJ75"));
    }
    @Test
    public void testlogin(){
        String uname = "admin";
        String password = "admin";
        List<Pmanager> manager = null;
        List<Puser> user = null;
        QueryWrapper<Pmanager> qw1 = new QueryWrapper<>();
        qw1.eq("pname",uname);
        qw1.eq("ppassword",password);
        manager = mmapper.selectList(qw1);
        QueryWrapper<Puser> qw2 = new QueryWrapper<>();
        qw2.eq("uname",uname);
        qw2.eq("upassword",password);
        user = umapper.selectList(qw2);
//        System.out.println(manager);
//        System.out.println(user);
        if (!manager.isEmpty()){
            System.out.println("管理页面");
        }else if (!user.isEmpty()){
            System.out.println("用户页面");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
}
