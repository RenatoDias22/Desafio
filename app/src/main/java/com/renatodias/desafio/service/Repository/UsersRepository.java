package com.renatodias.desafio.service.Repository;

import android.app.ProgressDialog;
import android.content.Context;

import com.renatodias.desafio.Model.Users;
import com.renatodias.desafio.Model.User;
import com.renatodias.desafio.service.Network.UsersService;

import java.util.List;

import retrofit2.Callback;

public class UsersRepository {

    ProgressDialog progressDialog;
    private final Context context;
    private final UsersService usersService;
    private final UsersRepositoryListener aListener;

    public interface UsersRepositoryListener{
        void usersReady(List<Users> users);
        void notUseres();
        void userReady(User user);
        void notUser();
    }

    public UsersRepository(Context context, UsersRepositoryListener aListener) {
        this.context = context;
        this.usersService = new UsersService();
        this.aListener = aListener;
        this.setProgressLogin(context);
    }

    public void getUsers() {

        progressDialog.show();

        usersService
                .getAPI()
                .getUsers()
                .enqueue(new Callback<List<Users>>() {
                    @Override
                    public void onResponse(retrofit2.Call<List<Users>> call, retrofit2.Response<List<Users>> response) {
                        List<Users> result = response.body();

                        if(result != null)
                            aListener.usersReady(result);
                        else
                            aListener.notUseres();

                        progressDialog.dismiss();

                    }

                    @Override
                    public void onFailure(retrofit2.Call<List<Users>> call, Throwable t) {

                        progressDialog.dismiss();

                        try {
                            throw new InterruptedException("Erro na comunicação com o servidor!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void getUser(String name) {

        progressDialog.show();

        usersService
                .getAPI()
                .getUser(name)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                        User result = response.body();

                        if(result != null)
                            aListener.userReady(result);
                        else
                            aListener.notUser();

                        progressDialog.dismiss();

                    }

                    @Override
                    public void onFailure(retrofit2.Call<User> call, Throwable t) {

                        progressDialog.dismiss();

                        try {
                            throw new InterruptedException("Erro na comunicação com o servidor!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void setProgressLogin(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Carregando...");
    }
}
