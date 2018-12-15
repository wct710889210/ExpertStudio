package com.pwfz.controller;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.model.FileItemModle;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.service.FileItemService;
import com.pwfz.service.Producename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/file")
public class FileItemController {

    @Autowired
    FileItemService fileItemService;
    @Autowired
    FileItemRepository fileItemRepository;
    @Autowired
    Producename producename;

    @RequestMapping("select")
    @ResponseBody
    public List<FileItemModle> findallfile()
    {
        ModuleItem moduleItem=new ModuleItem();
        moduleItem.setId(1);
        moduleItem.setType("1");
        int u=1;

        return fileItemService.selectfile(moduleItem);
    }

    @RequestMapping("savefile")
    @ResponseBody
    public String savefile()
    {
        FileItemModle fileItemModle=new FileItemModle();
        fileItemModle.setFilePath("uzi");
        fileItemModle.setId(123);
        fileItemModle.setFileName("fdsfa");
        fileItemService.savefileitem(fileItemModle);
        return "success";
    }

    @RequestMapping("deletefile")
    @ResponseBody
    public String deletefile()
    {
        int id=1;
        User user=new User();
        user.setId(2);
        FileItem fileItem=new FileItem();
        fileItem.setUploadUser(user);
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
