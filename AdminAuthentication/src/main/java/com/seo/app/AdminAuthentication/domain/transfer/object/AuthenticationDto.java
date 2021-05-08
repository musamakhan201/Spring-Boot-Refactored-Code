package com.seo.app.AdminAuthentication.domain.transfer.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class AuthenticationDto {
    private String username;
    private String password;

}
