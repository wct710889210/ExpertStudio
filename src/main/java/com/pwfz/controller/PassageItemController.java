package com.pwfz.controller;

import com.pwfz.entity.PassageItem;
import com.pwfz.modle.FileItemModle;
import com.pwfz.modle.PassageItemModule;
import com.pwfz.repository.Passageupdate;
import com.pwfz.service.PassageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@RequestMapping("/singlepassage")
public class PassageItemController {
    @Autowired
    PassageItemService passageItemService;

    @RequestMapping("get")
    @ResponseBody
    public PassageItemModule select()
    {
        int id=1;
        PassageItemModule passageItemModule=passageItemService.findpassage(id);
        return passageItemModule;
    }

    @RequestMapping("update")
    @ResponseBody
    public void updatepassage()
    {
        String content="IGnbnb";
        int userid=1;
        int id=1;
       PassageItemModule passageItemModule=new PassageItemModule();
       passageItemModule.setUserId(userid);
       passageItemModule.setContent(content);
        passageItemService.updatepassage(content,userid);
        int result=1;

        System.out.println(result);
    }



}