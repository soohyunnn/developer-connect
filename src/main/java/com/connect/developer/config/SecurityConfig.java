package com.connect.developer.config;

import com.connect.developer.config.jwt.JwtAccessDeniedHandler;
import com.connect.developer.config.jwt.JwtAuthenticationEntryPoint;
import com.connect.developer.config.jwt.JwtSecurityConfig;
import com.connect.developer.config.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 6. jwt 패키지에서 만들었던 5개의 클래스를 SecurityConfig에 추가
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //@EnableGlobalMethodSecurity는 @PreAuthorize 어노케이션을 메소드단위로 추가하기 위해서 적용
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    /**
     * SecurityConfig는 TokenProvider, JwtAuthenticationEntryPoint, JwtAccessDeniedHandler 주입
     * @param tokenProvider
     * @param jwtAuthenticationEntryPoint
     * @param jwtAccessDeniedHandler
     */
    public SecurityConfig(
            TokenProvider tokenProvider,
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
            JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    /**
     * PasswordEncoder는 BCryptPasswordEncoder를 사용
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/**", "/favicon.io");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //토큰을 사용하기 때문에 csrf 설정은 disable Exception을 핸들링할때 만들었던 클래스들을 추가해줍니다.
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                //세션을 사용하지 않기 때문에 세션 설정을 STATELESS로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/signup").permitAll()
                .anyRequest().authenticated()

                //jwtFilter를 addFilterBefore로 등록했던 JwtSecurityConfig클래스로 적용
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

    }

}
