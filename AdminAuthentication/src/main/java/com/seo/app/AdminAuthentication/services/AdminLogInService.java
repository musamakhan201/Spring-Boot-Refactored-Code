package com.seo.app.AdminAuthentication.services;

import com.seo.app.AdminAuthentication.domain.transfer.object.AdminLogInDto;
import com.seo.app.AdminAuthentication.domains.AdminLogInDomain;
import com.seo.app.AdminAuthentication.repository.AdminLogInRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminLogInService {
    private final Logger log = LoggerFactory.getLogger(AdminLogInService.class);

    @Autowired
    AdminLogInRepository adminLogInRepository;

    public String loginUser(AdminLogInDto adminLogInDto)
    {
        AdminLogInDomain adminLogInDomain=new AdminLogInDomain();
        adminLogInDomain.setUsername(adminLogInDto.getUsername());
        adminLogInDomain.setPassword(adminLogInDto.getPassword());
        adminLogInRepository.save(adminLogInDomain);
        String responseMessage = "Admin Logged In";
        log.info(responseMessage);
        return responseMessage;
    }
}
