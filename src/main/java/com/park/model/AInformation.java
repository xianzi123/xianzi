package com.park.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AInformation {
  @TableId(value = "a_information_id",type = IdType.AUTO)
  private long aInformationId;
  @TableField(value = "a_title")
  private String aTitle;
  @TableField(value = "a_time")
  private java.sql.Timestamp aTime;
  @TableField(value = "a_content")
  private String aContent;
  private long recommend;


}
