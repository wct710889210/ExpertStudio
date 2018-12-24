package com.pwfz.controller;

import com.pwfz.entity.PassageItem;
import com.pwfz.model.FileItemModle;
import com.pwfz.model.Json;
import com.pwfz.model.PassageItemModule;
import com.pwfz.model.SessionInfo;
import com.pwfz.repository.PassageItemRepository;
import com.pwfz.service.PassageItemService;
import com.pwfz.service.Producename;
import com.pwfz.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/passage")
public class PassageItemController {
    @Autowired
    PassageItemService passageItemService;
    @Autowired
    Producename producename;
    @Autowired
    UploadfileService uploadfileService;
    @Autowired
    PassageItemRepository passageItemRepository;

    @RequestMapping("getListbyModel")
    @ResponseBody
    public List<PassageItemModule> find(int modelId)
    {
        List<PassageItemModule> lists=passageItemService.selectpassage(modelId);
        return lists;
    }

    @RequestMapping("getList")
    @ResponseBody
    public List<PassageItemModule> select(int userId)
    {
        List<PassageItemModule> passageItemModules= passageItemService.findpassage(userId);
        return passageItemModules;
    }

    @RequestMapping("upload")
    @ResponseBody
    public Json updatepassage(HttpServletRequest request, MultipartFile passagephoto, PassageItemModule passageItemModule, HttpSession session) {

//        SessionInfo sessionInfo=(SessionInfo)session.getAttribute("sessioninfo");
//        passageItemModule.setUserId(sessionInfo.getId());
        String packagename = "uploadfiles/passagephoto";
        Json json = new Json();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());passageItemModule.setReleaseTime(timestamp);
        System.out.println(passageItemModule.getId());

        if (passagephoto!=null&&passagephoto.getOriginalFilename()!=null) {
            try {
                String randomFileName = uploadfileService.sendfile(passagephoto, packagename, request);
                passageItemModule.setTitlePhotoPath("/"+packagename+"/" + randomFileName);
                json.setSuccess(true);
                json.setMsg("添加成功");
                json.setObj(passageItemModule);
                passageItemService.updatepassage(passageItemModule);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
            }
        }
        else
        {
            if(passageItemModule.getId()==0)
            {
                passageItemService.updatepassage(passageItemModule);
                json.setSuccess(true);
                json.setMsg("添加成功");
                json.setObj(passageItemModule);
            }
            else {
                PassageItem passageItem = passageItemRepository.findPassageItemById(passageItemModule.getId());
                passageItemModule.setTitlePhotoPath(passageItem.getTitlePhotoPath());
                passageItemService.updatepassage(passageItemModule);
                json.setSuccess(true);
                json.setMsg("编辑成功");
                json.setObj(passageItemModule);
            }
        }

        return json;
    }


    @RequestMapping("delete")
    @ResponseBody
    public String deletefile(int id)
    {
        passageItemService.deletefile(id);
        return "success";
    }

    @RequestMapping("top")
    @ResponseBody
    public String toppassage(int id,String order)
    {
        passageItemService.toppassage(id, order);
        return "success";
    }



}
