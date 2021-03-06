package com.pwfz.service.Impl;

import com.pwfz.entity.PassageItem;
import com.pwfz.model.PassageItemModule;
import com.pwfz.repository.ModuleRepository;
import com.pwfz.repository.PassageItemRepository;
import com.pwfz.service.PassageItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassageItemServiceImp implements PassageItemService {
    @Autowired
    PassageItemRepository passageItemRepository;
    @Autowired
    ModuleRepository moduleRepository;


    @Override
    public List<PassageItemModule> findpassage(int id) {
        List<PassageItemModule> passageItemModules=new ArrayList<>();
        List<PassageItem> passageItems=passageItemRepository.findAllByUserId(id);
        for(PassageItem passageItem:passageItems)
        {
            PassageItemModule passageItemModule=new PassageItemModule();
            BeanUtils.copyProperties(passageItem, passageItemModule);
            passageItemModules.add(passageItemModule);
        }
        return passageItemModules;
    }

    @Override
    public void updatepassage(PassageItemModule passageItemModule) {
        PassageItem passageItem=new PassageItem();
        BeanUtils.copyProperties(passageItemModule,passageItem);
        passageItem.setModuleItem(moduleRepository.findOne(passageItemModule.getModelId()));
        passageItemRepository.save(passageItem);

    }

    @Override
    public void deletefile(int id) {
        passageItemRepository.delete(id);
    }

    @Override
    public void toppassage(int id,String order) {
        PassageItem passageItem=passageItemRepository.findOne(id);
        if(order.equals("true"))
        {
            passageItem.setTop(1);
        }
        else{
            passageItem.setTop(0);
        }
        passageItemRepository.save(passageItem);

    }

    @Override
    public List<PassageItemModule> selectpassage(int modelId) {
        List<PassageItem> passageItems=passageItemRepository.findpassageByModleId(modelId);
        List<PassageItemModule> passageItemModules=new ArrayList<>();
        for(PassageItem passageItem:passageItems)
        {
            PassageItemModule passageItemModule=new PassageItemModule();
            BeanUtils.copyProperties(passageItem,passageItemModule);
            passageItemModule.setModelId(modelId);
            passageItemModules.add(passageItemModule);
        }
        return passageItemModules;
    }
}
