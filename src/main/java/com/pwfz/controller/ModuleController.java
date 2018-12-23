package com.pwfz.controller;

import com.pwfz.model.Json;
import com.pwfz.model.ModuleModel;
import com.pwfz.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    /**
     * 获取用户模块
     * @return  模块列表
     */
    @RequestMapping("get")
    public List<ModuleModel> get(){
        int userId = 1;

        return moduleService.get(userId);
    }

    /**
     * 新增模块
     * @param module 模块模型对象
     * @return 是否成功（json形式）
     */
    @RequestMapping("add")
    public Json add(ModuleModel module){
        Json json = new Json();
        int id = moduleService.add(module);
        json.setSuccess(true);
        json.setMsg("添加成功");
        module.setId(id);
        json.setObj(module);
        return json;
    }

    /**
     * 删除模块
     * @param moduleId 删除模块的id
     * @return 是否成功（json形式）
     */
    @RequestMapping("delete")
    public Json delete(int moduleId){
        //todo 删除模块相关数据
        moduleService.delete(moduleId);
        Json json = new Json();
        json.setSuccess(true);
        json.setMsg("删除了id为"+moduleId+"的module");
        return json;
    }

    /**
     * 获取后台目录结构
     * @return 后台目录结构
     */
    @RequestMapping("backGet")
    public Json backGet(){
        int userId = 1;

        Json json = new Json();
        json.setMsg("后台目录结构");
        json.setObj(moduleService.backGet(userId));
        json.setSuccess(true);
        return json;
    }

    /**
     * 获取用户可访问模块
     * @return 用户可访问模块
     */
    @RequestMapping("getAccessible")
    public Json getAccessible(){
        int userId = 1;

        Json json = new Json();
        Map<String,String> result = moduleService.getAccessible(userId);
        json.setSuccess(true);
        json.setMsg("用户可访问模块");
        json.setObj(result);
        return json;
    }
}
