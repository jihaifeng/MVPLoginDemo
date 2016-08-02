package com.lucky.mvplogindemo.Interface;

import com.lucky.mvplogindemo.Model.UserInfoModel;

/**
 * Created by jihf on 2016/7/29 0029.
 */
public interface UserLoginView {
  String getUserName();

  String getUserPass();

  void showLoading();

  void hideLoading();

  void showErrMsg(String errMsg);

  void toNextActivity(UserInfoModel user);

  void clearUserName();

  void clearUserPass();
}
