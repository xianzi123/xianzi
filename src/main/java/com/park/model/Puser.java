package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "puser")
public class Puser {
  @TableId(value = "uid",type = IdType.AUTO)
  private long uid;
  private String uname;
  private String upassword;
  private String uphone;
  @TableField(value = "plate_phone")
  private String platePhone;
  private String sex;

}
