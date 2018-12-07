package com.renatodias.desafio.viewControllers;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.renatodias.desafio.adapters.UserAdapter;
import com.renatodias.desafio.Model.User;
import com.renatodias.desafio.Model.Users;
import com.renatodias.desafio.Util.Constant;
import com.renatodias.desafio.R;
import com.renatodias.desafio.viewModel.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity implements UsersViewModel.UsersViewModelListener, UserAdapter.UsersAdapterListener{

    UserAdapter adapter;

    MaterialSearchView searchView;
    TextView textView;

    UsersViewModel usersModel;
    List<Users> usersList;
    List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_activity);
        textView = (TextView) findViewById(R.id.textView_msg);
        setupNavigation();
        usersList = new ArrayList<>();
        userList = new ArrayList<>();
        this.setupRecycleView();
        this.setupSearch();

        usersModel = new UsersViewModel(this, this);
        usersModel.getUsers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public void usersViewModelChange(List<Users> users) {
        for (Users user: users) {
            usersModel.getUser(user.getLogin());
            Constant.Users.add(user);
        }
    }

    @Override
    public void notUsersViewModelChange() {

        setVisibilityErro(true);
        Toast.makeText(this, "Ainda não há usuarios disponiveis.", Toast.LENGTH_LONG).show();

    }

    @Override
    public void userViewModelChange(User user) {
        Constant.User.add(user);
        userList.add(user);

        adapter.setUsersList(userList);
        adapter.notifyDataSetChanged();
    }

    public void setVisibilityErro(boolean isVisibility) {
        if (isVisibility == true) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.INVISIBLE);
        }
    }

    public void setupRecycleView() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void userViewAdapterChange(User user) {
        Constant.user = user;
        Intent intent = new Intent(this, UserDetailsActivity.class);
        startActivity(intent);
    }

    public void setupNavigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lista de Usuários");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }

    private void setupSearch() {
        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

                adapter.setUsersList(userList);
                adapter.notifyDataSetChanged();
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    List<User> newUsers = new ArrayList<>();
                    for (User user: Constant.User) {
                        if (user.getName() != null && user.getName().contains(newText)){
                            newUsers.add(user);
                        }
                    }
                    if(newUsers.size() < 1){
                        setVisibilityErro(true);
                    }else{
                        setVisibilityErro(false);
                    }
                    adapter.setUsersList(newUsers);
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.setUsersList(userList);
                    adapter.notifyDataSetChanged();
                    setVisibilityErro(false);
                }

                return true;
            }
        });
    }
}
