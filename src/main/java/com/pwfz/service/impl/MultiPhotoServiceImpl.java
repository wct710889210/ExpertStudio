package com.pwfz.service.impl;

import com.pwfz.entity.MultiPhotoItem;
import com.pwfz.model.MultiPhotoModel;
import com.pwfz.repository.ModuleRepository;
import com.pwfz.repository.MultiPhotoRepository;
import com.pwfz.service.MultiPhotoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultiPhotoServiceImpl implements MultiPhotoService {
    @Autowired
    private MultiPhotoRepository multiPhotoRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<MultiPhotoModel> get(int moduleId) {
        List<MultiPhotoItem> items = multiPhotoRepository.getByModuleId(moduleId);
        List<MultiPhotoModel> models = new ArrayList<>();
        for (MultiPhotoItem item:items)
            models.add(entityToModel(item));
        return models;
    }

    @Override
    public void save(List<MultiPhotoModel> models) {
        int count = 0;
        List<MultiPhotoItem> items = new ArrayList<>();
        for (MultiPhotoModel model:models){
            MultiPhotoItem item = new MultiPhotoItem();
            BeanUtils.copyProperties(model,item);
            item.setModuleItem(moduleRepository.findOne(model.getId()));
            item.setSequence(count++);
            items.add(item);
        }
        multiPhotoRepository.save(items);
    }

    private MultiPhotoModel entityToModel(MultiPhotoItem item){
        MultiPhotoModel model = new MultiPhotoModel();
        BeanUtils.copyProperties(item,model);
        model.setModuleId(item.getModuleItem().getId());
        return model;
    }
}
