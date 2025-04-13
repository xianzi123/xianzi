package com.park.controller;
import com.park.model.ParkingArea;
import com.park.service.ParkingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hxy
 * @create 2024-4-10 9:36
 */
@Controller
public class ParkingAreaController {
    @Autowired
    private ParkingAreaService pas;
    @ResponseBody
    @RequestMapping("/selectParkingArea")
    public ParkingArea selectParkingArea(int areaId){

        ParkingArea parkingArea = pas.selectPackingArea(areaId);

        return parkingArea;
    }
    //查询所有停车区域信息
    @ResponseBody
    @RequestMapping("/selectAllParkingArea")
    public List<ParkingArea> selectAllPackingArea(){
        List<ParkingArea> parkingAreas = pas.selectAllPackingArea();
        return parkingAreas;
    }
    //新增停车区域信息
    @ResponseBody
    @RequestMapping("/addParkingArea")
    public int addPackingArea(ParkingArea p){
        p.setATime(new Timestamp(System.currentTimeMillis()));
        System.out.println(p.getATime());
        return pas.addPackingArea(p);

    }
    //删除停车区域信息
    @ResponseBody
    @RequestMapping("/deleteParkingArea")
    public int deletePackingArea(int aid){

        int i = pas.deletePackingArea(aid);
        System.out.println(aid+"获取到");
        return i;
    }
    //获取停车费用
    @ResponseBody
    @RequestMapping("/getParkingAreaPrice")
    public int getParkingArea(int areaId){
        int i = pas.getPrice(areaId);
        return i;
    }



}
