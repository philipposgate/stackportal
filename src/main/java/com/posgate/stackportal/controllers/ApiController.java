package com.posgate.stackportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posgate.stackportal.model.StackPortalModel;
import com.posgate.stackportal.services.StackPortalService;

@RestController
@RequestMapping("api")
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private StackPortalService stackPortalService;

	@GetMapping("/test")
	public ResponseEntity test() {
		logger.info("GET /api/test");
        return ResponseEntity.ok(HttpStatus.OK);
	}    

	@GetMapping("/model")
	public StackPortalModel getModel() {
		logger.info("GET /api/model");
        return stackPortalService.getStackPortalModel();
	}    

	@GetMapping("/model/refresh")
	public ResponseEntity getRefreshModel() {
		logger.info("GET /api/model/refresh");
		stackPortalService.refreshModels();
        return ResponseEntity.ok(HttpStatus.OK);
	}    

}
