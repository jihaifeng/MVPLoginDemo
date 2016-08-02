package com.lucky.mvplogindemo.Interface;

/**
 * Created by jihf on 2016/7/29 0029.
 */
public interface UserLoginInterface {
  public void login(String userName,String userPass,LoginListener loginListener);
}
