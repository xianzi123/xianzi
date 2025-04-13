package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.park.mapper.CarMapper;
import com.park.mapper.PUserMapper;
import com.park.model.Car;
import com.park.model.Puser;
import com.park.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hxy
 * @create 2024-4-12 11:12
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper mapper;
    @Autowired
    private PUserMapper umapper;
    @Override
    public Car selectByUid(int uid) {
        QueryWrapper<Car> qw = new QueryWrapper<Car>();
        qw.eq("uid",uid);
        return mapper.selectOne(qw);
    }

    @Override
    public int insert(long uid,String carBrand,String color,String plateNumber) {
        QueryWrapper<Puser> qw = new QueryWrapper<Puser>();
        qw.eq("uid",uid);
        Puser puser = umapper.selectOne(qw);
        String uname = puser.getUname();
        Car car = new Car(0,carBrand,color,plateNumber,uid,uname,"未入库");
        int insert = mapper.insert(car);
        return insert;
    }

    @Override
    public int update(long uid, String carBrand, String color, String plateNumber) {
        QueryWrapper<Car> qw = new QueryWrapper<Car>();
        qw.eq("uid",uid);
        Car car = mapper.selectOne(qw);
        car.setCarBrand(carBrand);
        car.setColor(color);
        car.setPlateNumber(plateNumber);
        int i = mapper.updateById(car);
        return i;
    }
}
