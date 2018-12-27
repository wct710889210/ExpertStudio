package com.pwfz.service;

import com.pwfz.model.ModuleModel;

import java.util.List;
import java.util.Map;

public interface ModuleService {
    List<ModuleModel> get(int userId);
    ModuleModel add(ModuleModel module);
    void delete(int moduleId);
    Map<String,List<ModuleModel>> backGet(int userId);
    Map<String,String> getAccessible(int userId);
}
