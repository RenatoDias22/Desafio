package com.renatodias.desafio.Model;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.renatodias.desafio.BR;

public class User extends BaseObservable {

    @SerializedName("login")
    public String login;

    @SerializedName("id")
    public int id;

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

    @SerializedName("name")
    public String name;

    @SerializedName("company")
    public String company;

    @SerializedName("blog")
    public String blog;

    @SerializedName("location")
    public String location;

    @SerializedName("public_repos")
    public int public_repos;

    @SerializedName("public_gists")
    public int public_gists;

    @SerializedName("followers")
    public int followers;

    @SerializedName("following")
    public int following;

    public User(String login, int id, String node_id, String avatar_url, String gravatar_id, String url, String html_url, String name, String company, String blog, String location, int public_repos, int public_gists, int followers, int following) {
        this.setLogin(login);
        this.setId(id);
        this.setNodeId(node_id);
        this.setAvatarUrl(avatar_url);
        this.setGravatarId(gravatar_id);
        this.setUrl(url);
        this.setHtmlUrl(html_url);
        this.setName(name);
        this.setCompany(company);
        this.setBlog(blog);
        this.setLocation(location);
        this.setPublicRepos(public_repos);
        this.setPublicGists(public_gists);
        this.setFollowers(followers);
        this.setFollowing(following);
    }

    public User(){}

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
    public int getId() {
        return id;
    }

    @Bindable
    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
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

    @Bindable
    public void setHtmlUrl(String html_url) {
        this.html_url = html_url;
        notifyPropertyChanged(BR.htmlUrl);
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getCompany() {
        return company;
    }

    @Bindable
    public void setCompany(String company) {
        this.company = company;
        notifyPropertyChanged(BR.company);
    }

    @Bindable
    public String getBlog() {
        return blog;
    }

    @Bindable
    public void setBlog(String blog) {
        this.blog = blog;
        notifyPropertyChanged(BR.blog);
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    @Bindable
    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public int getPublicRepos() {
        return public_repos;
    }

    @Bindable
    public void setPublicRepos(int public_repos) {
        this.public_repos = public_repos;
        notifyPropertyChanged(BR.publicRepos);
    }

    @Bindable
    public int getPublicGists() {
        return public_gists;
    }

    @Bindable
    public void setPublicGists(int public_gists) {
        this.public_gists = public_gists;
        notifyPropertyChanged(BR.publicGists);
    }

    @Bindable
    public int getFollowers() {
        return followers;
    }

    @Bindable
    public void setFollowers(int followers) {
        this.followers = followers;
        notifyPropertyChanged(BR.following);
    }

    @Bindable
    public int getFollowing() {
        return following;
    }

    @Bindable
    public void setFollowing(int following) {
        this.following = following;
        notifyPropertyChanged(BR.following);
    }

}
