package com.pwfz.service.impl;

import com.pwfz.entity.Photo;
import com.pwfz.model.PhotoModel;
import com.pwfz.repository.PhotoRepository;
import com.pwfz.repository.UserRepository;
import com.pwfz.service.PhotoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PhotoRepository photoRepository;

    @Override
    public void add(PhotoModel model) {
        Photo photo = new Photo();
        BeanUtils.copyProperties(model,photo);
        photo.setUser(userRepository.findOne(model.getUserId()));
        photoRepository.save(photo);
    }

    @Override
    public List<PhotoModel> getByUser(int userId) {
        List<Photo> photos = photoRepository.getByUserId(userId);
        List<PhotoModel> models = new ArrayList<>();
        for (Photo photo:photos){
            PhotoModel model = new PhotoModel();
            BeanUtils.copyProperties(photo,model);
            model.setUserId(photo.getUser().getId());
            models.add(model);
        }
        return models;
    }
}
