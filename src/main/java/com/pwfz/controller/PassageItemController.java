package com.pwfz.controller;

import com.pwfz.model.FileItemModle;
import com.pwfz.model.Json;
import com.pwfz.model.PassageItemModule;
import com.pwfz.service.PassageItemService;
import com.pwfz.service.Producename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/passage")
public class PassageItemController {
    @Autowired
    PassageItemService passageItemService;
    @Autowired
    Producename producename;

    @RequestMapping("get")
    @ResponseBody
    public PassageItemModule select()
    {
        PassageItemModule passageItemModule=passageItemService.findpassage(1);
        return passageItemModule;
    }

    @RequestMapping("update")
    @ResponseBody
    public Json updatepassage(HttpServletRequest request, MultipartFile passagephoto,PassageItemModule passageItemModule)
    {
        Json json = new Json();
        FileItemModle fileItemModle=new FileItemModle();
        fileItemModle.setFileName("nbnb");
        String rootPath = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath();
        //如果父目录不存在，则创建父目录
        File parent  = new File(rootPath+File.separator+"uploadpassage"+File.separator+"passagephoto");
        if(!parent.exists())
            parent.mkdirs();

        String fileName = passagephoto.getOriginalFilename();
        String randomFileName = producename.producename()+fileName.substring(fileName.lastIndexOf(".")+1);
        String path = File.separator+"uploadpassage"+File.separator+"passagephoto"+File.separator+randomFileName;
        File file = new File(rootPath+path);
        System.out.println(file.getAbsolutePath());
        try {
            passagephoto.transferTo(file);
            passageItemModule.setTitlePhotoPath("/uploadpassage/passagephoto/"+randomFileName);
            passageItemService.updatepassage(passageItemModule);
            json.setSuccess(true);
            json.setMsg("添加成功");
            json.setObj(fileItemModle);
        } catch (IOException e) {
            e.printStackTrace();
            json.setSuccess(false);
        }finally {
            return json;
        }
    }



}
