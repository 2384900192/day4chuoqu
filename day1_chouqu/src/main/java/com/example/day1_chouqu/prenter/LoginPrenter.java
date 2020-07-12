package com.example.day1_chouqu.prenter;

import com.example.day1_chouqu.base.BasePrenter;
import com.example.day1_chouqu.model.LoginModel;
import com.example.day1_chouqu.view.LoginView;

public class LoginPrenter extends BasePrenter<LoginView> {

    private LoginModel mLoginModel;

    @Override
    protected void initModel() {
        mLoginModel = new LoginModel();
        addModel(mLoginModel);
    }
}
