package com.pwfz.controller;

import com.pwfz.model.Json;
import com.pwfz.model.MultiPhotoModel;
import com.pwfz.service.MultiPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/multiPhoto")
public class MultiPhotoController {
    @Autowired
    private MultiPhotoService multiPhotoService;

    @RequestMapping("get")
    public Json get(int moduleId){
        Json json = new Json();
        json.setObj(multiPhotoService.get(moduleId));
        json.setSuccess(true);
        return json;
    }

    @RequestMapping("save")
    public Json save(@RequestBody List<MultiPhotoModel> models,int moduleId){
        Json json = new Json();
        multiPhotoService.save(models,moduleId);
        json.setSuccess(true);
        json.setMsg("保存成功");
        return json;
    }

}
