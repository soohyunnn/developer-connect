package com.connect.developer.user.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nickname;

    private String userId;

    private String password;

    @ElementCollection
    private List<String> interestingFields;

    private String email;

    private Long imageId;


//    public User(String name, String nickname, String userId, String password, List<String> interestingFields, String email, long imageId) {
//        this.name = name;
//        this.nickname = nickname;
//        this.userId = userId;
//        this.password = password;
//        this.interestingFields = interestingFields;
//        this.email = email;
//        this.imageId = imageId;
//    }


    public String getInfo() {
        return this.name;
    }
}
