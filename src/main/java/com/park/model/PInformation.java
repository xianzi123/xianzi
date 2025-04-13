package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 停车位信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "p_information")
public class PInformation {
    //id
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    //区域id
    private int areaId;
    //区域名称
    private String areaName;
    //入库时间
    private Timestamp date;
    //车辆编号
    private int cid;
    //车主
    private String uname;
    //停车位id
    private int parkId;


}
