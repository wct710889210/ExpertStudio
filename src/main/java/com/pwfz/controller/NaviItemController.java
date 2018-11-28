package com.pwfz.controller;

import com.pwfz.entity.NaviItem;
import com.pwfz.repository.NaviItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<NaviItem> get(){
        List<NaviItem> naviItems =  naviItemRepository.findAllFirstNavi(1);
        return naviItems;
    }

    private String naviToJson(List<NaviItem> naviItems,String result){
        result += "(";
        for (NaviItem naviItem:naviItems){
            result = result + naviItem.getName()+",";
            List<NaviItem> sons = naviItem.getSons();
            if(sons.size() != 0)
                result = naviToJson(sons,result);
        }
        result += ")";
        return result;
    }

    private void print(List<NaviItem> naviItems){
        System.out.print("(");
        for (NaviItem naviItem:naviItems){
            System.out.print(naviItem.getName()+",");
            List<NaviItem> sons = naviItem.getSons();
            if(sons.size() != 0)
                print(sons);
        }
        System.out.print(")");
    }
}
