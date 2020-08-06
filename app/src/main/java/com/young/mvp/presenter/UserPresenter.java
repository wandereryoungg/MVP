package com.young.mvp.presenter;

import com.young.mvp.bean.User;
import com.young.mvp.model.IUserModel;
import com.young.mvp.view.IUserView;

import java.util.List;

public class UserPresenter {

    private IUserView iUserView;
    private IUserModel iUserModel;

    public UserPresenter(IUserView iUserView, IUserModel iUserModel) {
        this.iUserView = iUserView;
        this.iUserModel = iUserModel;
    }

    public void saveUser(User user) {
        iUserModel.saveUser(user);
    }

    public void readUser(String name) {
        List<User> users = iUserModel.readUser(name);
        if (users != null && users.size() > 0) {
            for (User user : users) {
                iUserView.setUserName(user.getName());
                iUserView.setUserPassword(user.getPassword());
            }
        } else {
            iUserView.errorMsg("没有该用户");
        }
    }
}
