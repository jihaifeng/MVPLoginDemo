package com.lucky.mvplogindemo.Interface;

import com.lucky.mvplogindemo.Model.UserInfoModel;

/**
 * Created by jihf on 2016/7/29 0029.
 */
public interface LoginListener {
  void onSuccess(UserInfoModel userInfo);

  void onFailure(String errMsg);
}
