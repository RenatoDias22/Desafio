package com.renatodias.desafio.Views.UsersView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatodias.desafio.Data.Model.User;
import com.renatodias.desafio.databinding.UsersBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserView> {

    public interface UsersAdapterListener{
        void userViewAdapterChange(User user);
    }

    List<User> userList;
    LayoutInflater layoutInflater;
    private UsersAdapterListener listener;

    public UserAdapter(List<User> user, UsersAdapterListener listener) {

        this.setUsersList(user);
        this.listener = listener;

    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        UsersBinding usersBinding = UsersBinding.inflate(layoutInflater,parent,false);

        UserAdapter.UserView viewHolderUsers = new UserAdapter.UserView(usersBinding);
        return viewHolderUsers;
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {
        User usersViewModel = userList.get(position);
        holder.bind(usersViewModel, position);
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public void setUsersList(List<User> userList) {
        this.userList = userList;
    }

    public class UserView extends RecyclerView.ViewHolder {

        private UsersBinding usersBinding;

        public UserView(UsersBinding usersBinding) {
            super(usersBinding.getRoot());

            this.usersBinding = usersBinding;

        }

        public void bind(User user, int p) {
            this.usersBinding.setUser(user);
            final int position = p;

            this.usersBinding.cardViewUsers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.userViewAdapterChange(userList.get(position));
                }
            });
        }
    }
}
