package com.seo.app.AdminAuthentication.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "login_admins")
public class AdminLogInDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private int userId;
    private String email;
    private String password;
    @Column(columnDefinition="DATETIME")
    @JsonProperty("login_time")
    private String loginTime;

    public AdminLogInDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        loginTime = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
