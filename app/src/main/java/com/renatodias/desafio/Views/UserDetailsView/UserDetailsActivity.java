package com.renatodias.desafio.Views.UserDetailsView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.renatodias.desafio.Data.Model.User;
import com.renatodias.desafio.Data.Util.Constant;
import com.renatodias.desafio.R;
import com.renatodias.desafio.Views.UsersView.UsersActivity;

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
