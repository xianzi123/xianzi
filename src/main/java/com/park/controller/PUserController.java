package com.park.controller;

import com.park.model.Car;
import com.park.model.ParkingUsers;
import com.park.model.Pmanager;
import com.park.model.Puser;
import com.park.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author hxy
 * @create 2024-4-02 10:15
 */
@Controller
public class PUserController {
    @Autowired
    private PUserService us;
    @Autowired
    private PManagerService ms;
    @Autowired
    private CarService cs;
    @Autowired
    private PInformationService ps;
    @Autowired
    private ParkingAreaService as;
    @RequestMapping("login1")
    public String login(String username, String password, HttpSession session){
        Pmanager manager = ms.select(username,password);
        if (manager != null){
            long mid = manager.getMid();
            return "redirect:/managerNav.html?mid="+mid;
        }
        Puser user = us.select(username,password);
        if (user != null){
            long uid = user.getUid();
            return "redirect:/main.html?uid="+uid;
        }
        return "error";
    }
    //获取车辆信息
    @RequestMapping("getCar")
    @ResponseBody
    public Car getCar(int uid){
        if (cs.selectByUid(uid) != null){
            return cs.selectByUid(uid);
        }else return null;
    }
    //添加车辆信息
    @RequestMapping("addCar")
    @ResponseBody
    public int addCar(long uid,String carBrand,String color,String plateNumber){
        return cs.insert(uid,carBrand,color,plateNumber);
    }
    //修改车辆信息
    @RequestMapping("updateCar")
    public String updateCar(long uid,String carBrand,String color,String plateNumber){
        cs.update(uid,carBrand,color,plateNumber);
        return "redirect:/car.html?uid="+uid;
    }
    //获取当前区域停车位信息
    @RequestMapping("getArea")
    @ResponseBody
    public List<Integer> getArea(int areaId){
        return ps.selectByArea(areaId);
    }
    //获取我的停车位信息
    @RequestMapping("myPark")
    @ResponseBody
    public int getMyPark(long uid,int areaId){
        if (ps.getAreaId(uid) == areaId){
            return ps.selectByUid(uid);
        }else {
            return 0;
        }
    }
    //预约
    @RequestMapping("prePark")
    @ResponseBody
    public int prePark(long uid,int areaId,int parkId){
        System.out.println(uid+","+areaId+","+parkId);
        return ps.prePark(uid,areaId,parkId);
    }
    //取消预约
    @RequestMapping("dePrePark")
    @ResponseBody
    public int dePrePark(long uid,int areaId){
        return ps.dePrePark(uid,areaId);
    }
    //获取停车区域
    @RequestMapping("areaNum")
    @ResponseBody
    public int getAreaNum(){
        return as.getAreaNum();
    }
    //获取被预约的车位信息
    @RequestMapping("getPre")
    @ResponseBody
    public List<ParkingUsers> getPre(int areaId){
        return ps.getPre(areaId);
    }
    //出库
    @RequestMapping("parkOut")
    @ResponseBody
    public int parkOut(long uid,int areaId,int parkId){
        int i = ps.parkOut(uid, areaId, parkId);
        return i;
    }
    //入库
    @RequestMapping("parkIn")
    @ResponseBody
    public int parkIn(long uid,int areaId){
        System.out.println(uid+","+areaId);
        return ps.parkIn(uid,areaId);
    }
    //查询全部用户
    @ResponseBody
    @RequestMapping("/selectUser")
    public List<Puser> select(){
        List<Puser> pusers = us.selectAllPUser();

        return pusers;
    }
    //新增用户
    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(Puser p){
        return us.insert(p);

    }
    //删除用户
    @ResponseBody
    @RequestMapping("/deleteUser")
    public int deleteUser(String uid){
        System.out.println(uid);
        System.out.println(uid);
        String[] split = uid.split(",");
        int j=0;
//        //遍历split
        for (int i = 0; i < split.length; i++) {
            int id = Integer.parseInt(split[i]);
            int delete = us.delete(id);
            if (delete == 1){
                j++;
            }
        }

        if (j == split.length){
            return 1;
        }
       return 0;
    }
    //更改用户
    @ResponseBody
    @RequestMapping("/updateUser")
    public int updateUser(Puser p){
        System.out.println(p+"12341234432234543234234");
//        System.out.println(us.update(p)+"111111111111111111111111111111111435435");
        return us.update(p);

    }
}
