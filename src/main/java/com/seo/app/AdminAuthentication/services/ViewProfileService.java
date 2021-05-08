package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.AdminRegistrationDto;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewProfileService {
    @Autowired
    private AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public AdminRegistrationDto viewUser(int id) {
        return objectMapper.convertValue(adminRegistrationRepository.findById(id).get(), AdminRegistrationDto.class);
    }

}
