package com.renatodias.desafio.viewControllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.renatodias.desafio.Model.User;
import com.renatodias.desafio.Util.Constant;
import com.renatodias.desafio.R;
import com.renatodias.desafio.viewModel.UserDetailsViewModel;


public class UserDetailsActivity extends AppCompatActivity  implements UserDetailsViewModel.UsersViewDetailsModelListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserDetailsViewModel userDetailsModel = new UserDetailsViewModel( this, this);
        setContentView(userDetailsModel.getUserDetailsBinding().getRoot());

        userDetailsModel.bind(Constant.user);

    }

    @Override
    public void userViewDetailsModelChange(User user) {
    }
}
