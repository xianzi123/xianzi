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
@TableName(value = "park_order")
public class ParkOrder {
  @TableId(value = "oid",type = IdType.AUTO)
  private long oid;
  private String uname;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String plateNumber;
  private long areaId;
  private long parkMoney;



}
