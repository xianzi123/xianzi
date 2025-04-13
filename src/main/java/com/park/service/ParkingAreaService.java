package com.park.service;

import com.park.model.ParkingArea;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-10 10:54
 */
public interface ParkingAreaService {
    List<ParkingArea> selectAllPackingArea();
    ParkingArea selectPackingArea(int areaId);
    int deletePackingArea(int areaId);
    int updatePackingArea(ParkingArea p);
    int addPackingArea(ParkingArea p);

    int getAreaNum();
    public int getPrice(int areaId);

}
