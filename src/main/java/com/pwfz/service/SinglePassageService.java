package com.pwfz.service;

import com.pwfz.model.SinglePassageModel;
import org.springframework.stereotype.Service;

@Service
public interface SinglePassageService {
    String updatesinglepassage(SinglePassageModel singlePassageModel);
    SinglePassageModel findsinglepassage(int userId);
}
