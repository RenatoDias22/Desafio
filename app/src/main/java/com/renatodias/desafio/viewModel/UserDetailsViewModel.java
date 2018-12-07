package com.renatodias.desafio.viewModel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import com.renatodias.desafio.R;
import com.renatodias.desafio.databinding.UserDetailsBinding;
import com.renatodias.desafio.Model.User;

public class UserDetailsViewModel {

    public interface UsersViewDetailsModelListener{

        void userViewDetailsModelChange(User user);
    }

    private UsersViewDetailsModelListener listener;

    LayoutInflater layoutInflater;

    private UserDetailsBinding userDetailsBinding;

    public UserDetailsViewModel(Context context, UsersViewDetailsModelListener listener){

        this.listener = listener;
        this.userDetailsBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.content_user_details, null, false);

    }

    public void bind(User user) {
        this.userDetailsBinding.setUser(user);
    }

    public UserDetailsBinding getUserDetailsBinding() {
        return userDetailsBinding;
    }

}
