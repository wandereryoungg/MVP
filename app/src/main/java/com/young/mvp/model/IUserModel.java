package com.young.mvp.model;

import com.young.mvp.bean.User;

import java.util.List;

public interface IUserModel {
    void saveUser(User user);

    List<User> readUser(String name);
}
