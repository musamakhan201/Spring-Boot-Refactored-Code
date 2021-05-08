package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.AdminLogInDomain;
import com.seo.app.AdminAuthentication.Dto.AdminLogInDto;
import com.seo.app.AdminAuthentication.repository.AdminLogInRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminLogInService {
    private final Logger log = LoggerFactory.getLogger(AdminLogInService.class);

    @Autowired
    private AdminLogInRepository adminLogInRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseDto loginUser(AdminLogInDto adminLogInDto)
    {
        String responseMessage;
        AdminLogInDomain adminLogInDomain=new AdminLogInDomain();
        adminLogInDomain.setEmail(adminLogInDto.getEmail());
        adminLogInDomain.setPassword(adminLogInDto.getPassword());
        adminLogInRepository.save(adminLogInDomain);
        responseMessage = "Admin Logged In";
        log.info(responseMessage);
        return objectMapper.convertValue(responseMessage, ResponseDto.class);
    }
}
