package com.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.park.model.ParkingUsers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-01 12:58
 */
public interface UserMapper extends BaseMapper<ParkingUsers> {
    @Select("select * from parking_users where plate_number = #{plate_number}")
    ParkingUsers selectByPlateNumber(String plate_number);
    @Select("select * from parking_users where user_name = #{user_name}")
    ParkingUsers selectByUserName(String user_name);
    @Select("select * from parking_users where pusers_id = #{pusers_id}")
    ParkingUsers selectByUserId(int pusers_id);
    @Select("select * from parking_users")
    List<ParkingUsers> selectAll();
}
