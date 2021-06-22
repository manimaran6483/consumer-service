package com.consumer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.exception.ConsumerNotFoundException;
import com.consumer.exception.PropertyNotFoundException;
import com.consumer.feign.AuthClient;
import com.consumer.model.Property;
import com.consumer.request.BusinessPropertyRequest;
import com.consumer.request.ConsumerBusinessRequest;
import com.consumer.response.BusinessProperty;
import com.consumer.response.ConsumerBusiness;
import com.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {//class ConsumerController

	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private AuthClient auth;
	
	@PostMapping("/createConsumerBusiness")
	public String createConsumerBusiness(String token,
			@RequestBody final ConsumerBusinessRequest consumerBusiness) {
		log.info(token);
		if(auth.validate(token)) {
			log.info("Start CreateConsumerBusiness");
			final String message = consumerService.createConsumerBusiness(consumerBusiness);
			log.info("End CreateConsumerBusiness");
			return message;
		}
		return "Invalid token! Login First";
	}
	
	@PostMapping("/updateConsumerBusiness")
	public String updateConsumerBusiness(String token,
			@RequestBody final ConsumerBusiness consumerBusiness) throws ConsumerNotFoundException {
		if(auth.validate(token)) {
			log.info("Start updateConsumerBusiness");
			
			final String message = consumerService.updateConsumerBusiness(consumerBusiness);
			log.info("End updateConsumerBusiness");
			return message;
		}
		
		return "Invalid Token! Login again";
	}
	
	@GetMapping("/viewConsumerBusiness")
	//view ConsumerBusiness
	public ResponseEntity<?> viewConsumerBusiness(final String token, @RequestParam final Long consumerId) throws ConsumerNotFoundException {
		log.info(token);
		if(auth.validate(token)) {
			log.info("Start viewConsumerBusiness");
			
			ConsumerBusiness c = consumerService.viewConsumerBusiness(consumerId);
			log.info("End view ConsumerBusiness");
			return ResponseEntity.ok(c);
		}
		
		return ResponseEntity.badRequest().body("Invalid Token");
	}
	@PostMapping("/createBusinessProperty")
	public String createBusinessProperty(String token, @RequestBody BusinessPropertyRequest businessPropertyRequest) throws Exception {
		log.info("Start createBusinessProperty");
		final String messageResponse = consumerService.createBusinessProperty(businessPropertyRequest);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("End createBusinessProperty");
		return messageResponse;
	}
	@PostMapping("/updateBusinessProperty")
	public String updateBusinessProperty(String token,@RequestBody BusinessProperty businessPropertyDetails) throws PropertyNotFoundException {
		log.info("Start updateBusinessProperty");

		final String messageResponse = consumerService.updateBusinessProperty(businessPropertyDetails);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("End updateBusinessProperty");
		return messageResponse;
	}
	@GetMapping("/viewConsumerProperty")
	public ResponseEntity<?> viewConsumerProperty(String token, Long consumerid) {
		log.info("Start viewConsumerProperty");

		final Property property = consumerService.viewConsumerProperty(consumerid);
		log.debug("BusinessProperty Details: {}", property);
		log.info("End viewConsumerProperty");
		return ResponseEntity.ok(property);
	}
}
