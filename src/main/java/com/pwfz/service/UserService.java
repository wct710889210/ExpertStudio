package com.pwfz.service;

import com.pwfz.model.UserModel;

public interface UserService {
    UserModel login(UserModel userModel);
    void register(UserModel userModel) throws Exception;
}
