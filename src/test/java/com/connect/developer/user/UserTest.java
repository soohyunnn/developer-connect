package com.connect.developer.user;

import com.connect.developer.user.domain.User;
import com.connect.developer.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@SpringBootTest
class UserTest {

    @Autowired
    UserService userService;

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

    @Test
    void 회원_가입이_잘_되는지_확인하기() {
        User user = User.builder()
                .name("최수현")
                .nickname("soo")
                .userId("soohyunnn")
                .password("test1234")
                .interestingFields(Arrays.asList("프론트엔드", "백엔드"))
                .email("sksmsqodn20@gmail.com")
                .imageId(5L)
                .build();

        final User saveUser = userService.saveUser(user);
        assertThat("최수현").isEqualTo(saveUser.getName());
    }

}