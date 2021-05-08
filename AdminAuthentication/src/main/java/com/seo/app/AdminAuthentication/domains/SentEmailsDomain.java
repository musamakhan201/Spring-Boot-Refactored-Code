package com.seo.app.AdminAuthentication.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "sent_emails")
public class SentEmailsDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sent_email_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private AdminRegistrationDomain userRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private EmailTemplateDomain emailTemplateDomain;

    @Column(columnDefinition="DATETIME")
    private Date created_date;

    @Column(columnDefinition="DATETIME")
    private Date created_date_utc;

    private String sent_email;
}
