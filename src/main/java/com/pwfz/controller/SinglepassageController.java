package com.pwfz.controller;

import com.pwfz.model.Json;
import com.pwfz.model.SinglePassageModel;
import com.pwfz.service.SinglePassageService;
import com.pwfz.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/singlepassage")
public class SinglepassageController {
    @Autowired
    SinglePassageService singlePassageService;
    @Autowired
    UploadfileService uploadfileService;

    @RequestMapping("update")
    @ResponseBody
    public Json updatesinglepassage(HttpServletRequest request, MultipartFile photo, SinglePassageModel singlePassageModel)
    {
        String packagename = "webapp/singlepassagephoto";
        Json json = new Json();
        //文件判空，如果提交的是空，会产生null
        if (photo!=null&&photo.getOriginalFilename()!=null) {
            try {
                String randomFileName = uploadfileService.sendfile(photo, packagename, request);
                singlePassageModel.setPhotopath("/"+packagename+"/" + randomFileName);
                json.setSuccess(true);
                json.setMsg("添加成功");
                json.setObj(singlePassageModel);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
            }
        }else{
            System.out.println("don't have anything!");
        }
        singlePassageService.updatesinglepassage(singlePassageModel);
        return json;
    }

    @RequestMapping("select")
    @ResponseBody
    public SinglePassageModel selectsinglepassage(int moduleId)
    {
        return singlePassageService.findsinglepassage(moduleId);
    }
}
