package com.park.controller;

import com.park.model.AInformation;
import com.park.service.AInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hxy
 * @create 2024-4-08 23:58
 */
@Controller
public class AInformationController {
    @Autowired
    private AInformationService ais;
    //查询公告
    @ResponseBody
    @RequestMapping("/selectAnnouncement")
    public AInformation selectAnnouncement(int aInformationId){

        AInformation aInformation = ais.selectById(aInformationId);

        return aInformation;
    }
    //查询全部公告
    @ResponseBody
    @RequestMapping("/selectAnnouncements")
    public List<AInformation> selectAnnouncements(){
//        List<AInformation> aInformations = ais.selectAllAInformation();
//        System.out.println(aInformations.get(1).getATime()+"1111111111111111111111111");

        return ais.selectAllAInformation();
    }
    //新增公告
    @ResponseBody
    @RequestMapping("/addAnnouncement")
    public int addAnnouncement(AInformation p){
        p.setATime(new Timestamp(System.currentTimeMillis()));
        System.out.println(p.getATime());
        return ais.insert(p);

    }
    //删除公告
    @ResponseBody
    @RequestMapping("/deleteAnnouncement")
    public int deleteAnnouncement(String aid){
        String[] split = aid.split(",");
        System.out.println(aid);
        int j=0;
//        //遍历split
        for (int i = 0; i < split.length; i++) {
            int id = Integer.parseInt(split[i]);
            int delete = ais.delete(id);
            if (delete == 1){
                j++;
            }
        }

        if (j == split.length){
            return 1;
        }
            return 0;

    }
    @RequestMapping("AInformation")
    @ResponseBody
    public List<AInformation> showAll(){
        return ais.selectAll();
    }
    @RequestMapping("selectContent")
    @ResponseBody
    public String selContent(int aid){
        return ais.selectByIdU(aid);
    }


}
