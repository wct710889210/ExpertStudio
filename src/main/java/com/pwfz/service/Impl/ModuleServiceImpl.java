package com.pwfz.service.Impl;

import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.enumeration.ModuleType;
import com.pwfz.model.ModuleModel;
import com.pwfz.model.SinglePassageModel;
import com.pwfz.repository.ModuleRepository;
import com.pwfz.repository.UserRepository;
import com.pwfz.service.FileItemService;
import com.pwfz.service.ModuleService;
import com.pwfz.service.PassageItemService;
import com.pwfz.service.SinglePassageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    MultiPhotoServiceImpl multiPhotoService;
    @Autowired
    SinglePassageService singlePassageService;
    @Autowired
    PassageItemService passageItemService;
    @Autowired
    FileItemService fileItemService;

    @Override
    public List<ModuleModel> get(int userId) {
        List<ModuleItem> moduleItems = moduleRepository.findByUser(userId);
        List<ModuleModel> moduleModels = new ArrayList<>();
        for(ModuleItem item:moduleItems){
            moduleModels.add(entityToModel(item));
        }
        return moduleModels;
    }

    @Override
    public ModuleModel add(ModuleModel model) {
        ModuleItem item = modelToEntity(model);
        ModuleItem result = moduleRepository.save(item);
        model.setId(result.getId());
        model.setUsername(result.getUser().getName());
        model.setUserId(result.getUser().getId());
        return model;
    }

    @Override
    public void delete(int moduleId) {
        moduleRepository.delete(moduleId);
    }

    @Override
    public Map<String,List<ModuleModel>> backGet(int userId) {
        List<ModuleItem> items = moduleRepository.findByUser(userId);
        Map<String,List<ModuleModel>> backGet = new HashMap<>();
        for (ModuleItem item:items){
            ModuleModel model = entityToModel(item);
            String key = model.getType();
            if(backGet.containsKey(key))
                backGet.get(key).add(model);
            else{
                List<ModuleModel> models = new ArrayList<>();
                models.add(model);
                backGet.put(key,models);
            }
        }
        return backGet;
    }

    @Override
    public Map<String, String> getAccessible(int userId) {
        List<ModuleItem> items = moduleRepository.getAccessible();
        Map<String,String> result = new HashMap<>();
        for (ModuleItem item:items){
            ModuleModel model = entityToModel(item);
            String path1 = "";
            String type = model.getType();
            if(type.equals("文件下载"))
                path1 = "/file/";
            else if(type.equals("文章列表"))
                path1 = "/passageList/";
            else if(type.equals("单篇文章"))
                path1 = "/singlePassage/";
            result.put(model.getName(),path1+model.getId());
        }
        return result;
    }

    private ModuleModel entityToModel(ModuleItem moduleItem){
        ModuleModel model = new ModuleModel();
        BeanUtils.copyProperties(moduleItem,model);
        if(moduleItem.getType() == ModuleType.NAVIGATION){
            model.setType("导航栏");
        }
        else if(moduleItem.getType() == ModuleType.CAROUSEL)
        {
            model.setType("轮播多图");
            model.setContent(multiPhotoService.get(moduleItem.getId()));
        }
        else if(moduleItem.getType() == ModuleType.LISTPHOTO){
            model.setType("列表多图");
            model.setContent(multiPhotoService.get(moduleItem.getId()));
        }
        else if(moduleItem.getType() == ModuleType.FILEDOWNLOAD){
            model.setType("文件下载");
            model.setContent(fileItemService.selectfile(moduleItem.getId()));
        }
        else if(moduleItem.getType() == ModuleType.PASAGELIST) {
            model.setType("文章列表");
            model.setContent(passageItemService.selectpassage(moduleItem.getId()));
        }
        else if(moduleItem.getType() == ModuleType.SINGLEPASAGE){
            model.setType("单篇文章");
            List<SinglePassageModel> singlepassage = new ArrayList<>();
            singlepassage.add(singlePassageService.findsinglepassage(moduleItem.getId()));
            model.setContent(singlepassage);
        }
        model.setUserId(moduleItem.getUser().getId());
        model.setUsername(moduleItem.getUser().getName());
        return model;
    }

    private ModuleItem modelToEntity(ModuleModel model){
        ModuleItem item = new ModuleItem();
        BeanUtils.copyProperties(model,item);
        String type = model.getType();
        if(type.equals("导航栏"))
            item.setType(ModuleType.NAVIGATION);
        else if(type.equals("轮播多图"))
            item.setType(ModuleType.CAROUSEL);
        else if(type.equals("列表多图"))
            item.setType(ModuleType.LISTPHOTO);
        else if(type.equals("文件下载"))
            item.setType(ModuleType.FILEDOWNLOAD);
        else if(type.equals("文章列表"))
            item.setType(ModuleType.PASAGELIST);
        else if(type.equals("单篇文章"))
            item.setType(ModuleType.SINGLEPASAGE);
        User user = userRepository.findOne(model.getUserId());
        item.setUser(user);
        return item;
    }
}
