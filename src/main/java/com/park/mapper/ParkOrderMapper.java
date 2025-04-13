package com.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.park.model.ParkOrder;
import org.apache.ibatis.annotations.Select;

/**
 * @author hxy
 * @create 2024-4-12 14:47
 */
public interface ParkOrderMapper extends BaseMapper<ParkOrder> {
    @Select("select * from park_order where uname = #{uname} and end_time is null")
    ParkOrder selectOrder(String uname);
}
