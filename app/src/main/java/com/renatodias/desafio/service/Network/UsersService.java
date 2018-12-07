package com.renatodias.desafio.service.Network;


import com.renatodias.desafio.Model.Users;
import com.renatodias.desafio.Model.User;
import com.renatodias.desafio.Util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class UsersService {

    private static String BASE_URL = Constant.SERVER_URL;

    public interface  UsersAPI{
        @GET("users")
        Call<List<Users>> getUsers();

        @GET("users/{pk}")
        Call<User> getUser(@Path(value = "pk", encoded = true) String pk);
    }

    public UsersAPI getAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UsersAPI.class);
    }
}
