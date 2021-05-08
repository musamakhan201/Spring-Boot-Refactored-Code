package com.seo.app.AdminAuthentication.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "email_templates")
public class EmailTemplateDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int email_template_id;
    private String template_name;
    private String subject;
    private String body;
    private String footer;
    private Boolean is_html;

}