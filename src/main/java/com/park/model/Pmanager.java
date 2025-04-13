package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pmanager")
public class Pmanager {
  @TableId(value = "mid",type = IdType.AUTO)
  private long mid;
  private String pname;
  private String ppassword;
  private String pphone;




}
