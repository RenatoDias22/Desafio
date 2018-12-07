package com.renatodias.desafio.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.renatodias.desafio.BR;

public class Users extends BaseObservable{

    @SerializedName("login")
    public String login;

    @SerializedName("node_id")
    public String node_id;

    @SerializedName("avatar_url")
    public String avatar_url;

    @SerializedName("gravatar_id")
    public String gravatar_id;

    @SerializedName("url")
    public String url;

    @SerializedName("html_url")
    public String html_url;

    @SerializedName("id")
    public int id;

    public Users(String login, String node_id, String avatar_url, String gravatar_id, String url, String html_url, int id) {
        this.setLogin(login);
        this.setNodeId(node_id);
        this.setAvatarUrl(avatar_url);
        this.setGravatarId(gravatar_id);
        this.setUrl(url);
        this.setHtmlUrl(html_url);
        this.setId(id);
    }

    public Users() {
    }

    @Bindable
    public String getLogin() {
        return login;
    }

    @Bindable
    public void setLogin(String login) {
        this.login = login;
        notifyPropertyChanged(BR.login);
    }

    @Bindable
    public String getNodeId() {
        return node_id;
    }

    @Bindable
    public void setNodeId(String node_id) {
        this.node_id = node_id;
        notifyPropertyChanged(BR.nodeId);
    }

    @Bindable
    public String getAvatarUrl() {
        return avatar_url;
    }

    @Bindable
    public void setAvatarUrl(String avatar_url) {
        this.avatar_url = avatar_url;
        notifyPropertyChanged(BR.avatarUrl);
    }

    @Bindable
    public String getGravatarId() {
        return gravatar_id;
    }

    @Bindable
    public void setGravatarId(String gravatar_id) {
        this.gravatar_id = gravatar_id;
        notifyPropertyChanged(BR.gravatarId);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String html_url) {
        this.html_url = html_url;
        notifyPropertyChanged(BR.htmlUrl);
    }

    @Bindable
    public int getId() {
        return id;
    }

    @Bindable
    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

}
