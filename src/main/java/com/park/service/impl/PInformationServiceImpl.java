package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.park.mapper.*;
import com.park.model.*;
import com.park.service.CarService;
import com.park.service.PInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hxy
 * @create 2024-4-12 11:17
 */
@Service
@Transactional
public class PInformationServiceImpl implements PInformationService {
    @Autowired
    private ParkOrderMapper omapper;
    @Autowired
    private PInformationMapper mapper;
    @Autowired
    private PUserMapper umapper;
    @Autowired
    private CarMapper cmapper;
    @Autowired
    private ParkingUsersMapper pmapper;
    @Autowired
    private ParkingAreaMapper amapper;
    @Override
    public List<Integer> selectByArea(int areaId) {
        List<Integer> idlist = new ArrayList<>();
        QueryWrapper<PInformation> qw = new QueryWrapper<>();
        qw.eq("area_id",areaId);
        List<PInformation> list = mapper.selectList(qw);
        for (PInformation p : list){
            idlist.add(p.getParkId());
        }
        return idlist;
    }

    @Override
    public int selectByUid(long uid) {
        QueryWrapper<Puser> qw1 = new QueryWrapper<Puser>();
        qw1.eq("uid",uid);
        String uname = umapper.selectOne(qw1).getUname();
        QueryWrapper<PInformation> qw2 = new QueryWrapper<PInformation>();
        qw2.eq("uname",uname);
        PInformation pi = mapper.selectOne(qw2);
        return pi.getParkId();
    }

    @Override
    public int getAreaId(long uid) {
        QueryWrapper<Puser> qw1 = new QueryWrapper<Puser>();
        qw1.eq("uid",uid);
        String uname = umapper.selectOne(qw1).getUname();
        QueryWrapper<PInformation> qw2 = new QueryWrapper<PInformation>();
        qw2.eq("uname",uname);
        PInformation pi = mapper.selectOne(qw2);
        return pi.getAreaId();
    }

    @Override
    public int prePark(long uid,int areaId,int parkId) {
        QueryWrapper<Car> qw = new QueryWrapper<Car>();
        qw.eq("uid",uid);
        Car car = cmapper.selectOne(qw);
        String state = car.getState();
        System.out.println(state);
        if (state.equals("未入库")){
            car.setState("已预约");
            cmapper.updateById(car);
            ParkingUsers pu = new ParkingUsers();
            pu.setUid(car.getUid());
            pu.setPlateNumber(car.getPlateNumber());
            pu.setExamineState("已预约");
            pu.setUserName(car.getUname());
            pu.setAreaId(areaId);
            pu.setParkId(parkId);
            pmapper.insert(pu);
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int dePrePark(long uid,int areaId) {
        QueryWrapper<Car> qw = new QueryWrapper<Car>();
        qw.eq("uid",uid);
        Car car = cmapper.selectOne(qw);
        QueryWrapper<ParkingUsers> qw1 = new QueryWrapper<ParkingUsers>();
        qw1.eq("uid",uid);
        ParkingUsers pu = pmapper.selectOne(qw1);
        String state = car.getState();
        if (pu.getAreaId() != areaId){
            return 0;
        }else if (state.equals("已预约")){
            car.setState("未入库");
            cmapper.updateById(car);
            int parkId = pu.getParkId();
            pmapper.delete(qw1);
            return parkId;
        }else {
            return 0;
        }
    }

    @Override
    public List<ParkingUsers> getPre(int areaId) {
        System.out.println(areaId);
        QueryWrapper<ParkingUsers> qw = new QueryWrapper<ParkingUsers>();
        qw.eq("area_id",areaId);
        qw.eq("examine_state","已预约");
        if (pmapper.selectList(qw).isEmpty()){
            return null;
        }else {
            return pmapper.selectList(qw);
        }
    }



    @Override
    public int parkIn(long uid, int areaId) {
        QueryWrapper<Car> qw = new QueryWrapper<Car>();
        qw.eq("uid",uid);
        Car car = cmapper.selectOne(qw);
        QueryWrapper<ParkingUsers> qw1 = new QueryWrapper<ParkingUsers>();
        qw1.eq("uid",uid);
        ParkingUsers pu = pmapper.selectOne(qw1);
        String state = car.getState();
        if (pu == null){
            return 0;
        }else if (pu.getAreaId() != areaId){
            return 0;
        }else if (state.equals("已预约")){
//修改Car状态
            car.setState("已入库");
            cmapper.updateById(car);
//修改ParkingUsers信息
            pu.setExamineState("已通过");
            pmapper.updateById(pu);
//修改ParkArea信息
            QueryWrapper<ParkingArea> qw3 = new QueryWrapper<ParkingArea>();
            qw3.eq("area_id",areaId);
            ParkingArea area = amapper.selectOne(qw3);
            area.setRemaining(area.getRemaining()-1);
            amapper.updateById(area);
//添加PInformation信息
            PInformation pi = new PInformation();
            pi.setAreaId(areaId);
            pi.setAreaName(area.getAreaName());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            Timestamp startTime = Timestamp.valueOf(formatter.format(date));
            pi.setDate(startTime);
            pi.setCid(car.getCid());
            pi.setUname(car.getUname());
            pi.setParkId(pu.getParkId());
            mapper.insert(pi);
//添加订单信息
            ParkOrder order = new ParkOrder();
            order.setOid(-1);
            order.setUname(car.getUname());
            order.setStartTime(startTime);
            order.setEndTime(null);
            order.setPlateNumber(car.getPlateNumber());
            order.setAreaId(areaId);
            omapper.insert(order);
            return pi.getParkId();
        }else {
            return 0;
        }
    }
    @Override
    public int parkOut(long uid, int areaId, int parkId) {
//删除PInformation信息
        QueryWrapper<PInformation> qw1 = new QueryWrapper<PInformation>();
        qw1.eq("area_id",areaId);
        qw1.eq("park_id",parkId);
        mapper.delete(qw1);
//删除ParkingUsers信息
        QueryWrapper<ParkingUsers> qw2 = new QueryWrapper<ParkingUsers>();
        qw2.eq("uid",uid);
        pmapper.delete(qw2);
//修改Car状态
        QueryWrapper<Car> qw3 = new QueryWrapper<Car>();
        qw3.eq("uid",uid);
        Car car = cmapper.selectOne(qw3);
        car.setState("未入库");
        cmapper.updateById(car);
//修改ParkArea信息
        QueryWrapper<ParkingArea> qw4 = new QueryWrapper<ParkingArea>();
        qw4.eq("area_id",areaId);
        ParkingArea area = amapper.selectOne(qw4);
        area.setRemaining(area.getRemaining()+1);
        amapper.updateById(area);
//修改ParkOrder信息
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Timestamp endTime = Timestamp.valueOf(formatter.format(date));
        ParkOrder order = omapper.selectOrder(car.getUname());
        order.setEndTime(endTime);
        int hour = (int) ((endTime.getTime() - order.getStartTime().getTime())/1000/60/60);
        long parkMoney = hour * area.getHourlyPrice();
        order.setParkMoney(parkMoney);
        return omapper.updateById(order);
    }

}
