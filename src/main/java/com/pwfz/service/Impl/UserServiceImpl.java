package com.pwfz.service.Impl;

import com.pwfz.entity.User;
import com.pwfz.model.UserModel;
import com.pwfz.repository.UserRepository;
import com.pwfz.service.UserService;
import com.pwfz.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel login(UserModel userModel) {
        User user = userRepository.findByUsername(userModel.getUsername());
        System.out.println(user);
        if(user != null && user.getPassword().equals(MD5Util.md5(userModel.getPassword()))){
            userModel.setId(user.getId());
            userModel.setPassword(null);
            userModel.setName(user.getName());
            return userModel;
        }
        return null;
    }

    @Override
    public void register(UserModel userModel) throws Exception{
        if(userRepository.findByUsername(userModel.getUsername())!=null){
            throw new Exception("账号已经存在");
        }else {
            User user = new User();
            BeanUtils.copyProperties(userModel,user);
            user.setPassword(MD5Util.md5(userModel.getPassword()));
            userRepository.save(user);
        }
    }
}
