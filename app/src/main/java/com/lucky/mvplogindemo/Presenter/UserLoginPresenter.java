package com.lucky.mvplogindemo.Presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.lucky.mvplogindemo.Interface.LoginListener;
import com.lucky.mvplogindemo.Interface.UserLoginImp;
import com.lucky.mvplogindemo.Interface.UserLoginView;
import com.lucky.mvplogindemo.Model.UserInfoModel;

/**
 * Created by jihf on 2016/7/29 0029.
 */
public class UserLoginPresenter {
  private UserLoginView mUserLoginView;
  private UserLoginImp mUserLoginImp;
  private Handler mHandler;

  public UserLoginPresenter(UserLoginView userLoingView) {
    mUserLoginView = userLoingView;
    mUserLoginImp = new UserLoginImp();
    mHandler = new Handler();
  }

  public void login() {
    mUserLoginView.showLoading();
    if (isNullStr(mUserLoginView.getUserName())) {
      //UI线程里执行
      mHandler.post(new Runnable() {
        @Override public void run() {
          mUserLoginView.showErrMsg("请输入用户名");
          mUserLoginView.hideLoading();
        }
      });
      return;
    }
    if (isNullStr(mUserLoginView.getUserPass())) {
      //UI线程里执行
      mHandler.post(new Runnable() {
        @Override public void run() {
          mUserLoginView.showErrMsg("请输入密码");
          mUserLoginView.hideLoading();
        }
      });
      return;
    }
    mUserLoginImp.login(mUserLoginView.getUserName(), mUserLoginView.getUserPass(), new LoginListener() {
      @Override public void onSuccess(final UserInfoModel userInfo) {
        //UI线程里执行
        mHandler.post(new Runnable() {
          @Override public void run() {
            mUserLoginView.toNextActivity(userInfo);
            mUserLoginView.hideLoading();
          }
        });
      }

      @Override public void onFailure(final String errMsg) {
        //UI线程里执行
        mHandler.post(new Runnable() {
          @Override public void run() {
            mUserLoginView.showErrMsg(errMsg);
            mUserLoginView.hideLoading();
          }
        });
      }
    });
  }

  private boolean isNullStr(String Str) {
    boolean flag = false;
    if (TextUtils.isEmpty(Str) || "".equalsIgnoreCase(Str)) {
      flag = true;
    }
    return flag;
  }

  public void clear() {
    mUserLoginView.clearUserName();
    mUserLoginView.clearUserPass();
  }
}
