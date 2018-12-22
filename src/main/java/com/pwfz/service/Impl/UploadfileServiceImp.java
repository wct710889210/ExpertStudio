package com.pwfz.service.Impl;

import com.pwfz.service.Producename;
import com.pwfz.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class UploadfileServiceImp implements UploadfileService {
    @Autowired
    Producename producename;
    @Override
    public String sendfile(MultipartFile file, String packagename, HttpServletRequest request) throws IOException {
        String rootPath = new File(request.getServletContext().getRealPath("")).getParentFile().getAbsolutePath();
        //如果父目录不存在，则创建父目录
        File parent  = new File(rootPath+File.separator+packagename+File.separator);
        if(!parent.exists())
            parent.mkdirs();
        String fileName = file.getOriginalFilename();
        String randomFileName = producename.producename()+fileName.substring(fileName.lastIndexOf(".")+1);
        String path = File.separator+packagename+File.separator+File.separator+randomFileName;
        File realfile = new File(rootPath+path);
        System.out.println(realfile.getAbsolutePath());
        file.transferTo(realfile);
        return randomFileName;
    }
}
