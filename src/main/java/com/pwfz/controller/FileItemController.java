package com.pwfz.controller;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.model.FileItemModle;
import com.pwfz.model.Json;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.service.FileItemService;
import com.pwfz.service.Producename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileItemController {

    @Autowired
    FileItemService fileItemService;
    @Autowired
    Producename producename;

    @RequestMapping("select")
    @ResponseBody
    public List<FileItemModle> findallfile(int moduleId)
    {
   /*     int moduleId=1;*/
        return fileItemService.selectfile(moduleId);
    }

    @RequestMapping("savefile")
    @ResponseBody
    public Json savefile(HttpServletRequest request, MultipartFile files,FileItemModle fileItemModle)
    {
        Json json = new Json();
        String rootPath = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath();
        //如果父目录不存在，则创建父目录
        File parent  = new File(rootPath+File.separator+"uploadFiles"+File.separator+"file");
        if(!parent.exists())
            parent.mkdirs();

        String fileName = files.getOriginalFilename();
        String randomFileName = producename.producename()+fileName.substring(fileName.lastIndexOf(".")+1);
        String path = File.separator+"uploadFiles"+File.separator+"file"+File.separator+randomFileName;
        File file = new File(rootPath+path);
        System.out.println(file.getAbsolutePath());
        try {
            files.transferTo(file);
            fileItemModle.setFilePath("/uploadFiles/file/"+randomFileName);
            fileItemService.savefileitem(fileItemModle);
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

    @RequestMapping("deletefile")
    @ResponseBody
    public String deletefile(FileItemModle fileItemModle)
    {
        fileItemService.deletefile(fileItemModle);
        return "success";
    }



}
