package com.connect.developer.user;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void User_객체_생성_확인하기() {
        User user = new User("최수현", "SOO", "soohyunnn", "test1234", Arrays.asList("프론트앤드", "백엔드"), "sksmsqodn20@gmail.com", 5L);

        String info = user.getInfo();
        
        System.out.println("info - name :: " + info);
        assertThat("최수현").isEqualTo(info);
    }

}