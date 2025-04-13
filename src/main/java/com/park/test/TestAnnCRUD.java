package com.park.test;

import com.park.controller.AInformationController;
import com.park.controller.PUserController;
import com.park.model.AInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * @author hxy
 * @create 2024--09 11:24
 */

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAnnCRUD {
    @Autowired
    private AInformationController aic;
    @Test
    public void test() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        System.out.println(d);
        AInformation ai= new AInformation(0,"测试",d,"测试",0);
//        System.out.println(aic.selectAnnouncements());
        System.out.println(aic.selectAnnouncement(2));
//        System.out.println(aic.addAnnouncement(ai));
//        System.out.println(aic.deleteAnnouncement(1));

    }
}
