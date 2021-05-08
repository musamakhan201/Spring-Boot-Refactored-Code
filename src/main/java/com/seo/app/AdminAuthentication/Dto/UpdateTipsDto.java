package com.seo.app.AdminAuthentication.Dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTipsDto {
    public int tips_id;
    private String title;
    private String description;
}
