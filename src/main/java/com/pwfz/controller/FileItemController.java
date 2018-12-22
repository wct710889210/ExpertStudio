package com.pwfz.controller;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.model.FileItemModle;
import com.pwfz.model.Json;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.service.FileItemService;
import com.pwfz.service.Producename;
import com.pwfz.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/file")
public class FileItemController {

    @Autowired
    FileItemService fileItemService;
    @Autowired
    Producename producename;
    @Autowired
    UploadfileService uploadfileService;

    @RequestMapping("getList")
    @ResponseBody
    public List<FileItemModle> findallfile(int moduleId)
    {
   /*     int moduleId=1;*/
        return fileItemService.selectfile(moduleId);
    }

    @RequestMapping("upload")
    @ResponseBody
    public Json savefile(HttpServletRequest request, MultipartFile files,FileItemModle fileItemModle)
    {
        Json json = new Json();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        fileItemModle.setUploadTime(timestamp);
        String packagename="webapp/File";
        if (files!=null&&files.getOriginalFilename()!=null) {
            try {
                String randomFileName = uploadfileService.sendfile(files, packagename, request);
                fileItemModle.setFilePath(packagename+randomFileName);

                json.setSuccess(true);
                json.setMsg("添加成功");
                json.setObj(fileItemModle);
            } catch (IOException e) {
                e.printStackTrace();
                json.setSuccess(false);
            }
        }else{
            System.out.println("don't have anything!");
        }
        fileItemService.savefileitem(fileItemModle);
        return json;


    }

    @RequestMapping("delete")
    @ResponseBody
    public String deletefile(FileItemModle fileItemModle)
    {
        fileItemService.deletefile(fileItemModle);
        return "success";
    }

    @RequestMapping("select")
    @ResponseBody
    public List<FileItemModle> findfile(int userId)
    {
        return fileItemService.findfile(userId);
    }



}
