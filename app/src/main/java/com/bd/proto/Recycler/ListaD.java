package com.bd.proto.Recycler;

public class ListaD {
    private String login;
    private String avatar_url;
    private String html_url;

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public ListaD(String login, String gitUrl, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = gitUrl;
    }
}