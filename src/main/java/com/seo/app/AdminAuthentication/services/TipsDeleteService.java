package com.seo.app.AdminAuthentication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.AdminAuthentication.Dto.ResponseDto;
import com.seo.app.AdminAuthentication.domains.TipsDomain;
import com.seo.app.AdminAuthentication.repository.TipsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipsDeleteService {
    private final Logger log = LoggerFactory.getLogger(AdminRegistrationService.class);

    @Autowired
    private TipsRepository tipsRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public ResponseDto deleteTip(int id) {
        String responseMessage;
        TipsDomain tip = tipsRepository.getOne(id);
        tipsRepository.delete(tip);
        responseMessage = "Tip Deleted With ID: " + tip.getTipsId();
        log.info(responseMessage);
        return objectMapper.convertValue(responseMessage,ResponseDto.class);
    }
}
