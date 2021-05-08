package com.seo.app.AdminAuthentication.services;


import com.seo.app.AdminAuthentication.domain.transfer.object.AdminRegistrationDto;
import com.seo.app.AdminAuthentication.domains.AdminRegistrationDomain;
import com.seo.app.AdminAuthentication.repository.AdminRegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRegistrationService {
    private final Logger log = LoggerFactory.getLogger(AdminRegistrationService.class);

    @Autowired
    AdminRegistrationRepository adminRegistrationRepository;

    public String registerUser(AdminRegistrationDto userRegistrationDto)
    {
        AdminRegistrationDomain userRegistrationDomain=new AdminRegistrationDomain();
        userRegistrationDomain.setFirst_name(userRegistrationDto.getFirst_name());
        userRegistrationDomain.setLast_name(userRegistrationDto.getLast_name());
        userRegistrationDomain.setAddress(userRegistrationDto.getAddress());
        userRegistrationDomain.setEmail(userRegistrationDto.getEmail());
        userRegistrationDomain.setUsername(userRegistrationDto.getUsername());
        userRegistrationDomain.setPassword(userRegistrationDto.getPassword());
        adminRegistrationRepository.save(userRegistrationDomain);
        String responseMessage = "Admin has been register with ID " + userRegistrationDomain.getUser_id();
        log.info(responseMessage);
        return responseMessage;
    }

}
