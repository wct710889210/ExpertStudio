package com.pwfz.service;

import com.pwfz.model.MultiPhotoModel;

import java.util.List;

public interface MultiPhotoService {
    List<MultiPhotoModel> get(int moduleId);
    void save(List<MultiPhotoModel> models);
}
