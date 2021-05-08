package com.seo.app.AdminAuthentication.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

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
@Table(name = "Users")
public class AdminRegistrationDomain implements Serializable {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int user_id;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String username;
    private String password;
    @Column(columnDefinition = "DATETIME")
    private String created_date;
    public AdminRegistrationDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        created_date = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
