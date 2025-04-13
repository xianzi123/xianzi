package com.park.test;

import com.park.controller.AInformationController;
import com.park.controller.ParkingAreaController;
import com.park.model.AInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * @author hxy
 * @create 2024-4-10 12:31
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestParkAreaCRUD {
    @Autowired
    private ParkingAreaController pac;
    @Test
    public void test() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        System.out.println(d);
        com.park.model.ParkingArea pa= new com.park.model.ParkingArea(4,"测试",d,0,0,0);
//        System.out.println(pac.selectAllPackingArea());
//        System.out.println(pac.selectParkingArea(1));
        System.out.println(pac.deletePackingArea(4));
//        System.out.println(pac.addPackingArea(pa));
}

}
