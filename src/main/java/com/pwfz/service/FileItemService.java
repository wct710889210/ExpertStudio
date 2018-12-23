package com.pwfz.service;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.model.FileItemModle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileItemService {
    public List<FileItemModle> selectfile(int id);
  /*  public String addfile(FileItemModle fileItemModle,int userid);*/
    int savefileitem(FileItemModle fileItemModle);
    int deletefile(FileItemModle fileItem);
    List<FileItemModle> findfile(int userId);
}
