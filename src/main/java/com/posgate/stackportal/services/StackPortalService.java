package com.posgate.stackportal.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posgate.stackportal.model.StackPortalModel;

@Service
public class StackPortalService {
    
    private static final Logger logger = LoggerFactory.getLogger(StackPortalService.class);

    @Autowired
    private GitService gitService;

    private StackPortalModel stackPortalModel;

    public StackPortalModel getStackPortalModel() {

        try {
            String json = gitService.readFileToString("/data/data.json");
            logger.info("StackPortalModel json:\n" + json);
            ObjectMapper objectMapper = new ObjectMapper();
            stackPortalModel = objectMapper.readValue(json, StackPortalModel.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return stackPortalModel;
    }
}
