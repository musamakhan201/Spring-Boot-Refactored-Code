package com.seo.app.AdminAuthentication.Dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminLogInDto {
    private int user_id;
    private String email;
    private String password;
}
