package com.SD.MHT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_login_id;
    private String username;
    private String password;
    private String name;
    private String role;

    public UserLoginDetails(int user_login_id, String username, String password, String name, String role) {
        super();
        this.user_login_id = user_login_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public UserLoginDetails() {

    }

    //    @Override
//    public String toString() {
//        return "UserLoginDetails [user_login_id=" + user_login_id + ", username=" + username + ", password=" + password
//                + ", name=" + name + ", role=" + role + "]";
//    }
    @Override
    public String toString() {
        return "{\"user_login_id\": \"" + user_login_id + "\""
                +", \"username\": \"" + username + "\""
                + ", \"password\": \"" + password + "\""
                + ", \"name\": \"" + name + "\""
                + ", \"role\": \"" + role + "}";
    }
    public int getUser_login_id() {
        return user_login_id;
    }

    public void setUser_login_id(int user_login_id) {
        this.user_login_id = user_login_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
