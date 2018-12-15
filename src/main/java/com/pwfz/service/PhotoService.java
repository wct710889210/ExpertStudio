package com.pwfz.service;

import com.pwfz.model.PhotoModel;

import java.util.List;

public interface PhotoService {
    void add(PhotoModel model);
    List<PhotoModel> getByUser(int userId);
}
