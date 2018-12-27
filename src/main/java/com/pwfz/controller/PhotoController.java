package com.pwfz.controller;

import com.pwfz.model.Json;
import com.pwfz.model.PhotoModel;
import com.pwfz.model.SessionInfo;
import com.pwfz.service.PhotoService;
import com.pwfz.util.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    /**
     * 获取用户所有图片
     * @return
     */
    @RequestMapping("getAll")
    public Json get(){
        int userId = 1;

        Json json = new Json();
        json.setObj(photoService.getByUser(userId));
        json.setSuccess(true);
        json.setMsg("用户的所有图片");
        return json;
    }

    @RequestMapping("delete")
    public Json delete(int photoId){
        Json json = new Json();
        photoService.delete(photoId);
        json.setSuccess(true);
        json.setMsg("id为"+photoId+"的图片已删除");
        return json;
    }

    /**
     * 上传图片
     * @param photo
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("add")
    public Json add(MultipartFile photo, PhotoModel model, HttpServletRequest request, HttpSession session){
//        SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");
//        sessionInfo.getId();

        model.setUserId(1);

        Json json = new Json();

        String rootPath = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath();
        //如果父目录不存在，则创建父目录
        File parent  = new File(rootPath+File.separator+"uploadFiles"+File.separator+"photo");
        if(!parent.exists())
            parent.mkdirs();

        String fileName = photo.getOriginalFilename();
        String randomFileName = FileNameUtil.generateRandomFilename()+fileName.substring(fileName.lastIndexOf(".")+1);
        String path = File.separator+"uploadFiles"+File.separator+"photo"+File.separator+randomFileName;
        File file = new File(rootPath+path);
        System.out.println(file.getAbsolutePath());
        try {
            photo.transferTo(file);
            model.setPhotoPath("/uploadFiles/photo/"+randomFileName);
            photoService.add(model);
            json.setSuccess(true);
            json.setMsg("添加成功");
            json.setObj(model);
        } catch (IOException e) {
            e.printStackTrace();
            json.setSuccess(false);
        }finally {
            return json;
        }
    }

}
