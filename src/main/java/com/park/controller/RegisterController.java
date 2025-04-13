package com.park.controller;

import com.park.model.Puser;
import com.park.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxy
 * @create 2024-4-02 11:02
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService rs;
    @RequestMapping("/registerFrom")

    public String register(Puser p) {
        int register = rs.register(p);
//        System.out.println(p);
//            String s=register;
//        int register = rs.insert(p);
        System.out.println(p);
        System.out.println(register);
        return String.valueOf(register);
    }
}
