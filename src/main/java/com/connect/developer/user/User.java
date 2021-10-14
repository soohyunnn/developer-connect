package com.connect.developer.user;

import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private String name;
    private String nickname;
    private String userId;
    private String password;
    private List<String> interestingFields;
    private String email;
    private Long imageId;


    public User(String name, String nickname, String userId, String password, List<String> interestingFields, String email, long imageId) {
        this.name = name;
        this.nickname = nickname;
        this.userId = userId;
        this.password = password;
        this.interestingFields = interestingFields;
        this.email = email;
        this.imageId = imageId;
    }

    public String getInfo() {
        return this.name;
    }
}
