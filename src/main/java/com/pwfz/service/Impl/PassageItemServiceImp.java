package com.pwfz.service.Impl;

import com.pwfz.entity.PassageItem;
import com.pwfz.model.PassageItemModule;
import com.pwfz.repository.PassageItemRepository;
import com.pwfz.service.PassageItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageItemServiceImp implements PassageItemService {
    @Autowired
    PassageItemRepository passageItemRepository;


    @Override
    public PassageItemModule findpassage(int id) {
        PassageItemModule passageItemModule=new PassageItemModule();
        PassageItem passageItem=passageItemRepository.findPassageItemByUserId(id);
        BeanUtils.copyProperties(passageItem,passageItemModule);
        return passageItemModule;
    }

    @Override
    public int updatepassage(PassageItemModule passageItemModule) {
        /*int result=passageItemRepository.updatePassageItem(content,userid);
        return result;*/
        PassageItem passageItem=new PassageItem();
        BeanUtils.copyProperties(passageItemModule,passageItem);
        passageItemRepository.save(passageItem);
        return 1;

    }
}
