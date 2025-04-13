package com.park.service;

import com.park.model.AInformation;
import com.park.model.Puser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-09 0:06
 */

public interface AInformationService {
    AInformation selectById(int id);
    List<AInformation> selectAllAInformation();

    int insert(AInformation a);

    int delete(int id);
    List<AInformation> selectAll();
    //根据id查询公告内容
    String selectByIdU(int aid);

}
