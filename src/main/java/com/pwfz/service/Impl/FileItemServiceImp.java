package com.pwfz.service.Impl;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.model.FileItemModle;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.repository.ModuleRepository;
import com.pwfz.repository.UserRepository;
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

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    UserRepository userRepository;
    public List<FileItemModle> selectfile(int moduleId) {
        List<FileItem> fileItems = fileItemRepository.findAllFileItem(moduleId);
        List<FileItemModle> fileItemModles = new ArrayList<>();
        for (FileItem fileItem : fileItems) {
            FileItemModle fileItemModle = new FileItemModle();
            BeanUtils.copyProperties(fileItem,fileItemModle);
            fileItemModles.add(fileItemModle);
        }
        return fileItemModles;
    }


    @Override
    public int savefileitem(FileItemModle fileItemModle) {
        fileItemModle.setUserId(1);

        FileItem fileItem = new FileItem();
        BeanUtils.copyProperties(fileItemModle,fileItem);
        fileItem.setModuleItem(moduleRepository.findOne(fileItemModle.getModelId()));
        fileItem.setUploadUser(userRepository.findOne(fileItemModle.getUserId()));
        System.out.println(fileItem);
        fileItemRepository.save(fileItem);

        return 0;
    }

    @Override
    public int deletefile(FileItemModle fileItemModle) {
        FileItem fileItem=new FileItem();
        BeanUtils.copyProperties(fileItemModle,fileItem);
        fileItemRepository.delete(fileItem);
        return 0;
    }

    public List<FileItemModle> findfile(int userId)
    {
        List<FileItem> fileItems = fileItemRepository.findsomeFileItem(userId);
        List<FileItemModle> fileItemModles = new ArrayList<>();
        for(FileItem fileItem:fileItems)
        {
            FileItemModle fileItemModle=new FileItemModle();
            BeanUtils.copyProperties(fileItem,fileItemModle);
            fileItemModles.add(fileItemModle);
        }
        return fileItemModles;
    }

   /* @Override
    public String addfile(FileItemModle fileItemModle,int userid) {
        FileItem fileItem=new FileItem();
        BeanUtils.copyProperties(fileItemModle,fileItem);
        fileItemRepository.addfile(fileItem,userid);
        return null;
    }*/
}
