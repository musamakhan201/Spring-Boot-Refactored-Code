package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.PasswordUpdateDto;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordChangeService {
    private final Logger log = LoggerFactory.getLogger(AdminRegistrationService.class);

    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public ResponseDto changePassword(PasswordUpdateDto passwordUpdateDto) {
        String responseMessage;
        AdminRegistrationDomain admin = adminRegistrationRepository.getOne(passwordUpdateDto.getUser_id());
        if (admin.getPassword().equals(passwordUpdateDto.getOld_password())) {
            admin.setPassword(passwordUpdateDto.getNew_password());
            adminRegistrationRepository.save(admin);
            responseMessage = "Password CHanged of ID: " + admin.getUserId();
            log.info(responseMessage);
        }
        responseMessage = "Old Password is Incorrect";
        log.info(responseMessage);
        return objectMapper.convertValue(responseMessage,ResponseDto.class);
    }
}
