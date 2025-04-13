package com.park.service;

import com.park.model.ParkingUsers;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-12 11:17
 */
public interface PInformationService {
    //查询非空车位
    List<Integer> selectByArea(int areaId);
    //查询我的车位
    int selectByUid(long uid);
    //获取区域id
    int getAreaId(long uid);
    //预约
    int prePark(long uid,int areaId,int parkId);
    //取消预约
    int dePrePark(long uid,int areaId);
    //查询被预约的车位
    List<ParkingUsers> getPre(int areaId);
    //出库
    int parkOut(long uid,int areaId,int parkId);
    //入库
    int parkIn(long uid,int areaId);

}
