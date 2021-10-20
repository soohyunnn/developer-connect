package com.connect.developer.user.dto;

import lombok.*;

//토큰 정보를 담는 DTO
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;

}
