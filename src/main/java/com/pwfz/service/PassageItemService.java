package com.pwfz.service;

import com.pwfz.model.PassageItemModule;
import org.springframework.stereotype.Service;

@Service
public interface PassageItemService {
    PassageItemModule findpassage(int id);
    int updatepassage(String content,int userid);
}
