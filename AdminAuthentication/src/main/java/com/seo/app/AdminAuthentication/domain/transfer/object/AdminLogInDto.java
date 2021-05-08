package com.seo.app.AdminAuthentication.domain.transfer.object;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminLogInDto {
    private int user_id;
    private String username;
    private String password;
}
