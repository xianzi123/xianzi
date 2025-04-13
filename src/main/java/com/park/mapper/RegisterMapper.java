package com.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.park.model.Pmanager;
import com.park.model.Puser;
import org.apache.ibatis.annotations.Insert;

/**
 * @author hxy
 * @create 2024-4-02 11:16
 */
public interface RegisterMapper extends BaseMapper<Puser> {
    @Insert("insert into puser(uid,uname,upassword,uphone,plate_Phone,sex) values(null,#{uname},#{upassword},#{uphone},#{platePhone},#{sex})")
    int insertUser(Puser p);
}
