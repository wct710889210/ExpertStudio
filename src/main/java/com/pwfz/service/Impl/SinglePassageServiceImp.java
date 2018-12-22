package com.pwfz.service.Impl;

import com.pwfz.entity.Singlepassage;
import com.pwfz.model.SinglePassageModel;
import com.pwfz.repository.SinglePassageRepository;
import com.pwfz.service.SinglePassageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinglePassageServiceImp implements SinglePassageService {
    @Autowired
    SinglePassageRepository singlePassageRepository;
    @Override
    public String updatesinglepassage(SinglePassageModel singlePassageModel) {
        Singlepassage singlepassage = new Singlepassage();
        BeanUtils.copyProperties(singlePassageModel,singlepassage);
        singlePassageRepository.save(singlepassage);
        return "success";
    }

    @Override
    public SinglePassageModel findsinglepassage(int userId) {
        Singlepassage singlepassage=singlePassageRepository.findSinglepassageByUserId(userId);
        SinglePassageModel singlePassageModel = new SinglePassageModel();
        BeanUtils.copyProperties(singlepassage,singlePassageModel);
        return singlePassageModel;
    }
}
