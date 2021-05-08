package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.domains.ConfirmationTokenDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import com.seo.app.AdminAuthentication.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmRegisterationService {


    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseDto confirmRegistration(String confirmationToken) {
        ConfirmationTokenDomain token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        String response;
        if (token != null) {
            AdminRegistrationDomain user = adminRegistrationRepository.findByEmail(token.getUser().getEmail());
            user.setEnabled(true);
            adminRegistrationRepository.save(user);
            response = "Account Confirmation Completed!";
        } else {
            response = "The link is invalid or broken!";
        }
        return objectMapper.convertValue(response, ResponseDto.class);
    }
}
