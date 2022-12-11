package com.posgate.stackportal.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posgate.stackportal.model.StackPortalModel;

@Service
public class StackPortalService {
    
    @Autowired
    private GitService gitService;

    private StackPortalModel stackPortalModel;

    public StackPortalModel getStackPortalModel() {
        File jsonFile = gitService.getFile("/data/data.json");
        return null;
    }
}
