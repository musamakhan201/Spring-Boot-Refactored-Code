package com.seo.app.AdminAuthentication.controller;

import com.seo.app.AdminAuthentication.services.ConnectionService;
import com.seo.app.AdminAuthentication.domain.transfer.object.AuthenticationDto;
import com.seo.app.AdminAuthentication.domain.transfer.object.AdminLogInDto;
import com.seo.app.AdminAuthentication.domain.transfer.object.AdminRegistrationDto;
import com.seo.app.AdminAuthentication.services.AdminLogInService;
import com.seo.app.AdminAuthentication.services.AdminRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("seo")
public class AdminController {
    private final Logger log = LoggerFactory.getLogger(com.seo.app.AdminAuthentication.controller.AdminController.class);

    @Autowired
    private AdminRegistrationService adminRegistrationService;

    @Autowired
    ConnectionService connectionService;

    @Autowired
    private AdminLogInService adminLogInService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestBody AdminRegistrationDto adminRegistrationDto) {
        log.info("POST Call received at user/register with DTO" + adminRegistrationDto);
        return adminRegistrationService.registerUser(adminRegistrationDto);
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.POST)
    public String addLoginUser(@RequestBody AdminLogInDto adminLogInDto) {
        log.info("POST Call received at user/add with DTO" + adminLogInDto);
        return adminLogInService.loginUser(adminLogInDto);
    }

    @PostMapping(path = "/auth")
    public String getStatus(@RequestBody final AuthenticationDto authenticationDto) {
        List<String> users_list = new ArrayList<>();
        List<String> password_list = new ArrayList<>();
        int position = -1;
        String status = null;
        try {
            Connection connection = connectionService.createConnection();
            PreparedStatement statement = connection.prepareStatement("select username,password from users");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                users_list.add(rs.getString("username"));
                password_list.add(rs.getString("password"));
            }
        } catch (Exception e) {
            log.error(e.toString());

        }
        String e = authenticationDto.getUsername();
        String p = authenticationDto.getPassword();
        for (int i = 0; i < users_list.size(); i++) {


            if (e.equals(users_list.get(i)))
                position = i;
        }
        if (position == -1) {
            status = "username doesn't exist";
        } else if (position >= 0) {
            if (p.equals(password_list.get(position)))
                status = "user exist and password is true";
            else status = "user exist and password is false";

        }
        return status;
    }
}
