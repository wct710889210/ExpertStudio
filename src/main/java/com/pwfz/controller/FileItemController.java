package com.pwfz.controller;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.modle.FileItemModle;
import com.pwfz.repository.FileItemRepository;
import com.pwfz.service.FileItemService;
import com.pwfz.service.Imp.FileItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/file")
public class FileItemController {

    @Autowired
    FileItemService fileItemService;
    @Autowired
    FileItemRepository fileItemRepository;

    @RequestMapping("select")
    @ResponseBody
    public List<FileItemModle> findallfile()
    {
        ModuleItem moduleItem=new ModuleItem();
        moduleItem.setId(1);
        moduleItem.setType("1");

        return fileItemService.selectfile(moduleItem);
    }

}
