package com.pwfz.service.Impl;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.model.FileItemModle;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.service.FileItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileItemServiceImp implements FileItemService {
    @Autowired
    FileItemRepository fileItemRepository;

    public List<FileItemModle> selectfile(ModuleItem moduleItem) {
        List<FileItem> fileItems = fileItemRepository.findAllFileItem(moduleItem);
        List<FileItemModle> fileItemModles = new ArrayList<>();
        for (FileItem fileItem : fileItems) {
            FileItemModle fileItemModle = new FileItemModle();
           /* fileItemModle.setFileName(fileItem.getFileName());
            fileItemModle.setFilePath(fileItem.getFilePath());
            fileItemModle.setId(fileItem.getId());
            fileItemModle.setModuleItem(fileItem.getModuleItem());
            fileItemModle.setUploadTime(fileItem.getUploadTime());
            fileItemModle.setUploadUser(fileItem.getUploadUser());*/
            BeanUtils.copyProperties(fileItem,fileItemModle);
            fileItemModles.add(fileItemModle);
        }
        return fileItemModles;
    }


    @Override
    public int savefileitem(FileItemModle fileItemModle) {
        FileItem fileItem = new FileItem();
        BeanUtils.copyProperties(fileItemModle,fileItem);
        fileItemRepository.save(fileItem);

        return 0;
    }

    @Override
    public int deletefile(FileItem fileItem) {
        fileItemRepository.delete(fileItem);
        return 0;
    }

   /* @Override
    public String addfile(FileItemModle fileItemModle,int userid) {
        FileItem fileItem=new FileItem();
        BeanUtils.copyProperties(fileItemModle,fileItem);
        fileItemRepository.addfile(fileItem,userid);
        return null;
    }*/
}
