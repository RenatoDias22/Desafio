package com.renatodias.desafio.Views.UsersView;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.renatodias.desafio.Data.Model.User;
import com.renatodias.desafio.Data.Model.Users;
import com.renatodias.desafio.Data.Repository.UsersRepository;

import java.util.List;

public class UsersViewModel extends ViewModel implements UsersRepository.UsersRepositoryListener{

    public interface UsersViewModelListener{
        void usersViewModelChange(List<Users> users);
        void notUsersViewModelChange();
        void userViewModelChange(User user);
    }

    private UsersViewModelListener listener;

    Context context;
    UsersRepository usersRepository;

    MaterialSearchView searchView;

    public UsersViewModel(Context context, UsersViewModelListener listener){

        this.context = context;
        this.listener = listener;
        usersRepository = new UsersRepository(context, this);
    }

    public void getUsers(){

        this.usersRepository.getUsers();

    }

    public void getUser(String name){

        this.usersRepository.getUser(name);

    }


    @Override
    public void usersReady(List<Users> users) {
        listener.usersViewModelChange(users);
    }

    @Override
    public void notUseres() {

        listener.notUsersViewModelChange();
        Toast.makeText(context, "Ainda não há usuarios disponiveis.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void userReady(User user) {
        listener.userViewModelChange(user);
    }

    @Override
    public void notUser() { }

}
