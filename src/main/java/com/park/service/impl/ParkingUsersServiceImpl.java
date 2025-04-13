package com.park.service.impl;

import com.park.mapper.UserMapper;
import com.park.service.ParkingUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hxy
 * @create 2024-4-01 12:58
 */
@Service
public class ParkingUsersServiceImpl implements ParkingUsersService {
    @Autowired
    private UserMapper mapper;

}
