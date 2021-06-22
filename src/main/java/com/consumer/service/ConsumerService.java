package com.consumer.service;

import com.consumer.exception.ConsumerNotFoundException;
import com.consumer.exception.PropertyNotFoundException;
import com.consumer.model.Property;
import com.consumer.request.BusinessPropertyRequest;
import com.consumer.request.ConsumerBusinessRequest;
import com.consumer.response.BusinessProperty;
import com.consumer.response.ConsumerBusiness;


public interface ConsumerService {

	String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest);

	Long calBusinessValue(Long businessturnover, Long capitalinvested);

	Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset);

	String updateConsumerBusiness(ConsumerBusiness consumerBusinessDetails) throws ConsumerNotFoundException;

	ConsumerBusiness viewConsumerBusiness(Long consumerid) throws ConsumerNotFoundException;

	String createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws ConsumerNotFoundException;

	String updateBusinessProperty(BusinessProperty businessPropertyDetails) throws PropertyNotFoundException;

	Property viewConsumerProperty(Long consumerid);

}
