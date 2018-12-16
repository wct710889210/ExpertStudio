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
    public List<FileItemModle> findallfile()
    {
        int moduleid=1;
        return fileItemService.selectfile(moduleid);
    }

    @RequestMapping("savefile")
    @ResponseBody
    public Json savefile(HttpServletRequest request, MultipartFile files,FileItemModle fileItemModle)
    {
        Json json = new Json();
        fileItemModle.setFileName("nbnb");
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
    public String deletefile()
    {
        int id=3;
        String filename="nbnb";
        String filepath="IG";
        FileItem fileItem=new FileItem();
        fileItem.setId(id);
        fileItem.setFileName(filename);
        fileItem.setFilePath(filepath);
        fileItemService.deletefile(fileItem);
        return "success";
    }


   /* @RequestMapping("addfile")
    public String addfile(@RequestParam(value="userid",required=false) int userid, HttpServletRequest request) {
       *//* CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 设置编码
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        if (commonsMultipartResolver.isMultipart(request)) {//有文件上传
            System.out.println("have photo");
            MultipartHttpServletRequest fileRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = fileRequest.getFile("image");
            if ((!file.isEmpty()) && (!file.getOriginalFilename().equals(""))) {
                //String path = request.getServletContext().getRealPath("static"+File.separator+"uploadFiles");
                String path = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath() + File.separator + "uploadFiles";
                //send+="+not empty and path:"+path+"\n";
                String fileName = file.getOriginalFilename();
                File pFile = new File(path);
                pFile.setWritable(true, false);
                if (!pFile.exists()) {
                    pFile.mkdirs();
                }
                String ultiPath = path + File.separator + producename.producename() + fileName.substring(fileName.lastIndexOf(".") + 1);
*//*
         *//*   }*//*
*//*        }*//*
        System.out.println(userid);
        FileItemModle fileItemModle=new FileItemModle();
        fileItemModle.setId(123);
        fileItemModle.setFilePath("uzi");
        fileItemService.addfile(fileItemModle,userid);
        return "success";
    }*/
}
