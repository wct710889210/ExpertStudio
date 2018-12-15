package com.pwfz.controller;

import com.pwfz.entity.NaviItem;
import com.pwfz.repository.NaviItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/navi")
public class NaviItemController {
    @Autowired
    NaviItemRepository naviItemRepository;

    @RequestMapping(value = "get",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<NaviItem> get(int moduleId){
        List<NaviItem> naviItems =  naviItemRepository.findAllFirstNavi(moduleId);
        return naviItems;
    }

    @RequestMapping(value = "save",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String save(@RequestBody List<NaviItem> naviItems){
        //在更新之前设置顺序sequence，已经用下面的方式取代
//        int sequence = 1;
//        int subSequence;
//        for (NaviItem naviItem:naviItems){
//            naviItem.setSequence(sequence++);
//            subSequence = 1;
//            for (NaviItem son:naviItem.getSons()){
//                son.setSequence(subSequence++);
//            }
//        }

        //更新一级标题的序列顺序，二级标题使用@OrderColumn来维持顺序
        int sequence = 1;
        for (NaviItem naviItem:naviItems){
            naviItem.setSequence(sequence++);
        }
        //todo 失去关联后的NaviItem应该被删除
        naviItemRepository.updateNaviItems(naviItems);
        return "success";
    }

}
