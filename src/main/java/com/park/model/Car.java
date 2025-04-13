package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wang
 * @create 2024-04-07 14:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "car")
public class Car implements Serializable {
    @TableId(value = "cid",type = IdType.AUTO)
    //车辆编号
    private int cid;
    //车型
    private String carBrand;
    //颜色
    private String color;
    //车牌
    private String plateNumber;
    private long uid; 
    //车主
    private String uname;
    //状态
    private String state;

}
