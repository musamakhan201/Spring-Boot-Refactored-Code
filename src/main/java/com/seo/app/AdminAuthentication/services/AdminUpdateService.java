package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.AdminUpdateDto;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUpdateService {
    private final Logger log = LoggerFactory.getLogger(AdminRegistrationService.class);

    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public ResponseDto updateUser(AdminUpdateDto adminUpdateDto) {
        String responseMessage;
        AdminRegistrationDomain admin = adminRegistrationRepository.getOne(adminUpdateDto.getUser_id());
        admin.setFirstName(adminUpdateDto.getFirst_name());
        admin.setLastName(adminUpdateDto.getLast_name());
        admin.setAddress(adminUpdateDto.getAddress());
        admin.setEmail(adminUpdateDto.getEmail());
        adminRegistrationRepository.save(admin);
        responseMessage = "Admin Updated With ID: " + admin.getUserId();
        log.info(responseMessage);
        return objectMapper.convertValue(responseMessage, ResponseDto.class);
    }
}

