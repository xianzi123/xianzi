package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 停车用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "parking_users")
public class ParkingUsers {
    //停车用户id
    @TableId(value = "pusers_id",type = IdType.AUTO)
    private int pusersId;
    //用户姓名
    private String userName;
    //车牌号
    private String plateNumber;
    //审核状态
    private String examineState;
    //用户id
    private long uid;
    //区域id
    private int areaId;
    //停车位id
    private int parkId;
}
