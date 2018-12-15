package com.pwfz.controller;

import com.pwfz.model.Json;
import com.pwfz.model.PhotoModel;
import com.pwfz.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    /**
     * 获取用户所有图片
     * @param userId
     * @return
     */
    @RequestMapping("getAll")
    public Json get(int userId){
        Json json = new Json();
        json.setObj(photoService.getByUser(userId));
        json.setSuccess(true);
        json.setMsg("用户的所有图片");
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
    public Json add(MultipartFile photo, PhotoModel model, HttpServletRequest request){
        Json json = new Json();

        String rootPath = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath();
        //如果父目录不存在，则创建父目录
        File parent  = new File(rootPath+File.separator+"uploadFiles"+File.separator+"photo");
        if(!parent.exists())
            parent.mkdirs();

        String fileName = photo.getOriginalFilename();
        String randomFileName = generateRandomFilename()+fileName.substring(fileName.lastIndexOf(".")+1);
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

    public String generateRandomFilename() {
        String RandomFilename = "";
        Random rand = new Random();//生成随机数
        int random = rand.nextInt();
        Calendar calCurrent = Calendar.getInstance();
        int intDay = calCurrent.get(Calendar.DATE);
        int intMonth = calCurrent.get(Calendar.MONTH) + 1;
        int intYear = calCurrent.get(Calendar.YEAR);
        String now = String.valueOf(intYear) + "_" + String.valueOf(intMonth) + "_" +
                String.valueOf(intDay) + "_";
        RandomFilename = now + String.valueOf(random > 0 ? random : ( -1) * random) + ".";
        return RandomFilename;
    }
}
