package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLogoutService {
    private final Logger log = LoggerFactory.getLogger(AdminLogInService.class);

    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseDto logoutUser(int id) {
        String responseMessage;
        AdminRegistrationDomain admin = adminRegistrationRepository.getOne(id);
        admin.setLoggedIn(false);
        adminRegistrationRepository.save(admin);
        responseMessage = "Admin Logged Out With ID: " + admin.getUserId();
        log.info(responseMessage);
        return objectMapper.convertValue(responseMessage, ResponseDto.class);
    }
}
