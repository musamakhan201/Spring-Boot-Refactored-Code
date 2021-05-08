package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.AuthenticationDto;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationService {
    private final Logger log = LoggerFactory.getLogger(AdminAuthenticationService.class);

    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseDto authenticateUser(AuthenticationDto authenticationDto) {
        String responseMessage="";
        AdminRegistrationDomain admin = adminRegistrationRepository.findByEmail(authenticationDto.getEmail());
        if (admin != null) {
            if (admin.getPassword().equals(authenticationDto.getPassword())) {
                if (admin.isEnabled()) {
                    admin.setLoggedIn(true);
                    adminRegistrationRepository.save(admin);
                    responseMessage = "Admin Logged In With ID: " + admin.getUserId();
                    log.info(responseMessage);
                } else {
                    responseMessage = "Please first confirm your registration to login";
                    log.info(responseMessage);
                }
            }
        } else {
            responseMessage = "Username is incorrect";
            log.info(responseMessage);
        }
        return objectMapper.convertValue(responseMessage, ResponseDto.class);
    }
}
