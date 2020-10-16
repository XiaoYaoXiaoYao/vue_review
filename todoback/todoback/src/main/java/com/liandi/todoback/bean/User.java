package com.liandi.todoback.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体
 * */
@Setter
@Getter
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String urole;//角色
    private boolean ustate;//状态

    public User() {
    }

    public User(String username, String password, String email, String urole, boolean ustate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.urole = urole;
        this.ustate = ustate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", urole='" + urole + '\'' +
                ", ustate=" + ustate +
                '}';
    }
}
