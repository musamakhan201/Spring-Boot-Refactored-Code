package com.seo.app.AdminAuthentication.Dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateDto {
    private int user_id;
    private String old_password;
    private String new_password;
}
