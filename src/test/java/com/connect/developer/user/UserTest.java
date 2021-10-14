package com.connect.developer.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void User_객체_생성_확인하기() {
        User user = User.builder()
                .name("최수현")
                .nickname("soo")
                .userId("soohyunnn")
                .password("test1234")
                .interestingFields(Arrays.asList("프론트엔드", "백엔드"))
                .email("sksmsqodn20@gmail.com")
                .imageId(5L)
                .build();

        String info = user.getInfo();
        
        System.out.println("info - name :: " + info);
        assertThat("최수현").isEqualTo(info);
    }

}