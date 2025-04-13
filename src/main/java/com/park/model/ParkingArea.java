package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "parking_area")
/**
 * 停车区域类，用于管理停车区域的相关信息。
 */
public class ParkingArea {
  @TableId(value = "area_id",type = IdType.AUTO)
  private int areaId; // 停车区域ID
  private String areaName; // 停车区域名称
  private java.sql.Timestamp aTime; // 停车区域的建立时间
  private long remaining; // 剩余可用停车位数量
  private long totalNumber; // 总停车位数量
  private long hourlyPrice; // 每小时的停车费用

}
