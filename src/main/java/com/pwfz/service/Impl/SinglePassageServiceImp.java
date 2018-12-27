package com.pwfz.service.Impl;

import com.pwfz.entity.Singlepassage;
import com.pwfz.model.SinglePassageModel;
import com.pwfz.repository.ModuleRepository;
import com.pwfz.repository.SinglePassageRepository;
import com.pwfz.service.SinglePassageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinglePassageServiceImp implements SinglePassageService {
    @Autowired
    SinglePassageRepository singlePassageRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public String updatesinglepassage(SinglePassageModel singlePassageModel) {
        Singlepassage singlepassage = new Singlepassage();
        BeanUtils.copyProperties(singlePassageModel,singlepassage);
        singlepassage.setModuleItem(moduleRepository.findOne(singlePassageModel.getModuleId()));
        singlePassageRepository.save(singlepassage);
        return "success";
    }

    @Override
    public SinglePassageModel findsinglepassage(int moduleId) {
        Singlepassage singlepassage=singlePassageRepository.findSinglepassageByModuleId(moduleId);
        SinglePassageModel singlePassageModel = new SinglePassageModel();
        if (singlepassage==null)
            return null;
        BeanUtils.copyProperties(singlepassage,singlePassageModel);
        singlePassageModel.setModuleId(moduleId);
        return singlePassageModel;
    }
}
