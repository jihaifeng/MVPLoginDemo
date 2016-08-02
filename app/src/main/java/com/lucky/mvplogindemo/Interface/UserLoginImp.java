package com.lucky.mvplogindemo.Interface;

import com.lucky.mvplogindemo.Model.UserInfoModel;

/**
 * Created by jihf on 2016/8/2 0002.
 */
public class UserLoginImp implements UserLoginInterface {
  @Override public void login(final String userName, final String userPass, final LoginListener loginListener) {
    //模拟子线程耗时操作
    new Thread() {
      @Override public void run() {
        super.run();
        try {
          Thread.sleep(3*1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if ("jihf".equalsIgnoreCase(userName) && "123".equalsIgnoreCase(userPass)){
          //登陆成功
          UserInfoModel userInfoModel = new UserInfoModel();
          userInfoModel.setUserName(userName);
          userInfoModel.setUserPass(userPass);
          loginListener.onSuccess(userInfoModel);
        }else {
          //登陆失败
          loginListener.onFailure("用户名或密码错误！");
        }

      }
    }.start();
  }
}
