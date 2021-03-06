package com.connect.developer.user.domain;

import com.connect.developer.common.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity {

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

    private boolean activated = true;  //활성화 여부

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authorityName", referencedColumnName = "authorityName")}
    )
    private Set<Authority> authorities;

    public User(String subject, String name, Collection<? extends GrantedAuthority> authorities) {
    }


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
