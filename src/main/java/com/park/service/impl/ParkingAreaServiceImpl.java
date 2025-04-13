package com.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.park.mapper.ParkingAreaMapper;
import com.park.model.ParkingArea;
import com.park.model.Puser;
import com.park.service.ParkingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-10 10:54
 */
@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {
    @Autowired
    private ParkingAreaMapper pam;
    @Override
    public List<ParkingArea> selectAllPackingArea() {

        return pam.selectList(null);
    }

    @Override
    public ParkingArea selectPackingArea(int areaId) {

        return pam.selectById(areaId);
    }


    @Override
    public int deletePackingArea(int areaId) {

        return  pam.deleteById(areaId);
    }

    @Override
    public int updatePackingArea(ParkingArea p) {
        //返回更新函数
        UpdateWrapper<ParkingArea> pa = new UpdateWrapper<>();
        pa.set("area_name",p.getAreaName());
        pa.set("remaining",p.getRemaining());

        pa.set("total_number",p.getTotalNumber());
        pa.set("hourly_price",p.getHourlyPrice());
        pa.eq("area_id",p.getAreaId());
        if(pam.update(p,pa)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int addPackingArea(ParkingArea p) {

        return  pam.insert(p);
    }
    @Override
    public int getAreaNum() {
        return pam.selectCount(null);
    }
    //根据id查询停车费用
    public int getPrice(int areaId){
        return pam.getHourlyPrice(areaId);
    }
}
