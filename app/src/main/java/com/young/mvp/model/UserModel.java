package com.young.mvp.model;

import com.young.mvp.bean.User;

import org.litepal.LitePal;

import java.util.List;

public class UserModel implements IUserModel {
    @Override
    public void saveUser(User user) {
        user.save();
    }

    @Override
    public List<User> readUser(String name) {
        List<User> users = LitePal.where("name=?", name)
                .find(User.class);
        return users;
    }
}
