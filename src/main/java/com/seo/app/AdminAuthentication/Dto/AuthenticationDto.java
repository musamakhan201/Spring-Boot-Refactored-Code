package com.seo.app.AdminAuthentication.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class AuthenticationDto {
    private String email;
    private String password;

}
