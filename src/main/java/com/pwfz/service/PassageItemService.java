package com.pwfz.service;

import com.pwfz.model.PassageItemModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassageItemService {
    List<PassageItemModule> findpassage(int id);
    void updatepassage(PassageItemModule passageItemModule);
    void deletefile(int id);
}
