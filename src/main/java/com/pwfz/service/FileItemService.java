package com.pwfz.service;

import com.pwfz.entity.ModuleItem;
import com.pwfz.modle.FileItemModle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FileItemService {
    public List<FileItemModle> selectfile(ModuleItem moduleItem);
}
