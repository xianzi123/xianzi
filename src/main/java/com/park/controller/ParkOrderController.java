package com.park.controller;

import com.park.model.ParkOrder;
import com.park.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-12 15:09
 */
@Controller
public class ParkOrderController {
    @Autowired
    private ParkOrderService pos;
    @ResponseBody
    @RequestMapping("/selectAllOrder")
    public List<ParkOrder> selectAllOrder(){
        return pos.getAllOrder();
    }

}
