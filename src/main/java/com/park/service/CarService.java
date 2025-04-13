package com.park.service;

import com.park.model.Car;

/**
 * @author hxy
 * @create 2024-4-12 11:11
 */
public interface CarService {
    Car selectByUid(int uid);
    int insert(long uid,String carBrand,String color,String plateNumber);
    int update(long uid,String carBrand,String color,String plateNumber);
}
