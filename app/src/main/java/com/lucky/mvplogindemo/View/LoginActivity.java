package com.lucky.mvplogindemo.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lucky.mvplogindemo.Interface.UserLoginView;
import com.lucky.mvplogindemo.Model.UserInfoModel;
import com.lucky.mvplogindemo.Presenter.UserLoginPresenter;
import com.lucky.mvplogindemo.R;

public class LoginActivity extends AppCompatActivity implements UserLoginView {

  @BindView(R.id.edit_userName) EditText editUserName;
  @BindView(R.id.edit_userPass) EditText editUserPass;
  @BindView(R.id.btn_login) Button btnLogin;
  @BindView(R.id.btn_clear) Button btnClear;
  @BindView(R.id.pb_login) ProgressBar pbLogin;
  private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick({ R.id.btn_login, R.id.btn_clear }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_login:
        //登陆
        userLoginPresenter.login();
        break;
      case R.id.btn_clear:
        //清空
        userLoginPresenter.clear();
        break;
    }
  }

  @Override public String getUserName() {
    return editUserName.getText().toString();
  }

  @Override public String getUserPass() {
    return editUserPass.getText().toString();
  }

  @Override public void showLoading() {
    pbLogin.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    pbLogin.setVisibility(View.GONE);
  }

  @Override public void showErrMsg(String errMsg) {
    Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show();
  }

  @Override public void toNextActivity(UserInfoModel user) {

    Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
  }

  @Override public void clearUserName() {
    editUserName.setText("");
  }

  @Override public void clearUserPass() {
    editUserPass.setText("");
  }
}
