package com.seo.app.AdminAuthentication.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "tips")
public class TipsDomain implements Serializable {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tips_id")
    @JsonProperty("tips_id")
    public int tipsId;
    private String title;
    private String description;
    @Column(columnDefinition = "DATETIME")
    private String created_date;
    public TipsDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        created_date = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
