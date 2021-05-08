package com.seo.app.AdminAuthentication.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "admins")
public class AdminRegistrationDomain implements Serializable {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    @Column(name = "user_id")
    public int userId;
    @JsonProperty("first_name")
    @Column(name = "first_name")
    private String firstName;
    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String email;
    private String password;
    private boolean loggedIn;
    @Column(columnDefinition = "DATETIME")
    @JsonProperty("created_date")
    private String createdDate;
    private boolean isEnabled;
    public AdminRegistrationDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        createdDate = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
