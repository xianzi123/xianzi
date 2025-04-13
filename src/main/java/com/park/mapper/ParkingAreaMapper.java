package com.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.park.model.AInformation;
import com.park.model.ParkingArea;
import org.apache.ibatis.annotations.Select;

/**
 * @author hxy
 * @create 2024-4-10 10:55
 */
public interface ParkingAreaMapper extends BaseMapper<ParkingArea> {
    //根据area_id获取hourly_price
    @Select("select hourly_price from parking_area where area_id = #{areaId}")
    int getHourlyPrice(int areaId);
}
