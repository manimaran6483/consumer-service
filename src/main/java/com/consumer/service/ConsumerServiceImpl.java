package com.consumer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumer.exception.ConsumerNotFoundException;
import com.consumer.exception.PropertyNotFoundException;
import com.consumer.model.Business;
import com.consumer.model.Consumer;
import com.consumer.model.Property;
import com.consumer.repository.BusinessRepository;
import com.consumer.repository.ConsumerRepository;
import com.consumer.repository.PropertyRepository;
import com.consumer.request.BusinessPropertyRequest;
import com.consumer.request.ConsumerBusinessRequest;
import com.consumer.response.BusinessProperty;
import com.consumer.response.ConsumerBusiness;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Autowired
	private PropertyRepository propertyRepo;
	
	@Autowired
	private BusinessRepository businessRepo;
	@Override
	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusiness) {
		log.info("Start createConsumerBusiness Service");
		Consumer consumer=new Consumer(consumerBusiness.getFirstname(),consumerBusiness.getLastname(),
				consumerBusiness.getDob(),consumerBusiness.getBusinessname(),
				consumerBusiness.getEmail(),consumerBusiness.getPandetails(),
				consumerBusiness.getPhone(),consumerBusiness.getWebsite(),consumerBusiness.getBusinessoverview(),
				consumerBusiness.getValidity(),consumerBusiness.getAgentname(),consumerBusiness.getAgentid());
		log.debug("Consumer:",consumer);
		Consumer consumersave = consumerRepo.save(consumer);
		log.debug("Consumer Save:",consumersave);
		Long businessValue = calBusinessValue(consumerBusiness.getBusinessturnover(),
				consumerBusiness.getCapitalinvested());
		log.debug("BusinessValue:",businessValue);
		Business business = new Business(consumersave.getId(), consumerBusiness.getBusinesscategory(),
				consumerBusiness.getBusinesstype(), consumerBusiness.getBusinessturnover(),
				consumerBusiness.getCapitalinvested(), consumerBusiness.getTotalemployees(),
				businessValue, consumerBusiness.getBusinessage());
		log.debug("Business:",business);
		Business businessSave = businessRepo.save(business);
		log.debug("businessSave:",businessSave);
		log.info("End createConsumerBusiness");
		return "Successfully Created Consumer with Id:"+consumersave.getId()+"and Business with Id:"+businessSave.getId();
	}

	@Override
	public Long calBusinessValue(Long businessturnover, Long capitalinvested) {
		log.info("Start CalBusinessValue");
		if (businessturnover == 0 || capitalinvested == 0 || (businessturnover == capitalinvested)) {
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}

		Double x_ratio = (double) (businessturnover / capitalinvested);
		log.info("X_ratio: {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) businessturnover;
		Double x_min = (double) capitalinvested;
		Double range_diff = (double) (Range_max - Range_min);
		log.info("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.info("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double businessvalue = (range_diff * sat);
		log.debug("BusinessValue: {}", businessvalue);
		log.info("End CalBusinessValue");
		return (long)  Math.abs(Math.round(businessvalue));
		//return (long) 100000;
	}

	@Override
	public Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset) {
		log.info("Start calPropertyValue");
		if (usefullifeoftheAsset == 0 || salvagevalue == 0 || costoftheasset == 0 || (costoftheasset == salvagevalue)) {
			throw new NullPointerException("NullPointerException in calPropertyValue");
		}
		Double x_ratio = (double) ((costoftheasset - salvagevalue) / usefullifeoftheAsset);
		log.debug("x_ratio : {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costoftheasset / usefullifeoftheAsset);
		log.debug("x_max : {}", x_max);
		Double x_min = (double) (salvagevalue / usefullifeoftheAsset);
		log.debug("x_min : {}", x_min);
		Double range_diff = (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double propertyvalue = range_diff * sat;
		log.debug("propertyvalue  : {}", propertyvalue);
		log.info("End calPropertyValue");
		return (long) Math.abs(Math.round(propertyvalue));
		//return (long) 10000;
	}

	@Override
	public String updateConsumerBusiness(ConsumerBusiness consumerBusinessDetails) throws ConsumerNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start updateConsumerBusinessService");
		if(!consumerRepo.existsById(consumerBusinessDetails.getConsumerId())) {
			throw new ConsumerNotFoundException("Consumer not found");
		}

		Consumer consumer = consumerRepo.findById(consumerBusinessDetails.getConsumerId()).get();
		log.debug("Consumer:",consumer);
		Business business = businessRepo.findByConsumerId(consumerBusinessDetails.getConsumerId());
		log.debug("Business:",business);
		consumer.setFirstname(consumerBusinessDetails.getFirstname());
		consumer.setLastname(consumerBusinessDetails.getLastname());
		consumer.setDob(consumerBusinessDetails.getDob());
		consumer.setBusinessname(consumerBusinessDetails.getBusinessname());
		consumer.setPandetails(consumerBusinessDetails.getPandetails());
		consumer.setEmail(consumerBusinessDetails.getEmail());
		consumer.setPhone(consumerBusinessDetails.getPhone());
		consumer.setWebsite(consumerBusinessDetails.getWebsite());
		consumer.setBusinessoverview(consumerBusinessDetails.getBusinessoverview());
		consumer.setValidity(consumerBusinessDetails.getValidity());
		consumer.setAgentname(consumerBusinessDetails.getAgentname());
		consumer.setAgentid(consumerBusinessDetails.getAgentid());
		Consumer consumersave = consumerRepo.save(consumer);
		log.debug("ConsumerSave:",consumersave);
		Long businessValue = calBusinessValue(consumerBusinessDetails.getBusinessturnover(),
				consumerBusinessDetails.getCapitalinvested());
		log.debug("BusinessValue:",businessValue);
		business.setBusinesscategory(consumerBusinessDetails.getBusinesscategory());
		business.setBusinesstype(consumerBusinessDetails.getBusinesstype());
		business.setBusinessturnover(consumerBusinessDetails.getBusinessturnover());
		business.setCapitalinvested(consumerBusinessDetails.getCapitalinvested());
		business.setTotalemployees(consumerBusinessDetails.getTotalemployees());
		business.setBusinessvalue(businessValue);
		business.setBusinessage(consumerBusinessDetails.getBusinessage());
		
		Business businesssave = businessRepo.save(business);
		log.debug("BusinessSave:",businesssave);
		log.info("End UpdateConsumerBusinessService");
		return "Successfully Updated Consumer with Id:"+consumerBusinessDetails.getConsumerId()+
				"and Business Id:"+businesssave.getId();
	}

	@Override
	public ConsumerBusiness viewConsumerBusiness(Long consumerid) throws ConsumerNotFoundException {
		// TODO Auto-generated method stub
		log.info("Start viewConsumerBusinessService");
		Consumer consumers=null;
		try {
		consumers = consumerRepo.findById(consumerid).get();
		}catch(Exception e) {
			throw new ConsumerNotFoundException("Consumer Not Found");
		}
		log.debug("Consumer:",consumers);
		Business business = businessRepo.findByConsumerId(consumerid);
		log.debug("Business",business);
		ConsumerBusiness consumerBusinessDetails = new ConsumerBusiness(consumers.getFirstname(),
				consumers.getLastname(), consumers.getDob(), consumers.getBusinessname(), consumers.getPandetails(),
				consumers.getEmail(), consumers.getPhone(), consumers.getWebsite(), consumers.getBusinessoverview(),
				consumers.getValidity(), consumers.getAgentname(), consumers.getAgentid(), business.getId(),
				business.getConsumerId(), business.getBusinesscategory(), business.getBusinesstype(),
				business.getBusinessturnover(), business.getCapitalinvested(), business.getTotalemployees(),
				business.getBusinessvalue(), business.getBusinessage());
		log.debug("ConsumerBusiness Details:",consumerBusinessDetails);
		log.info("End ViewconsumerBusiness Service");
		
		return consumerBusinessDetails;
	}

	@Override
	public String createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws ConsumerNotFoundException {
		log.info("Start createConsumerBusinessService");
		if (!consumerRepo.existsById(businessPropertyRequest.getConsumerId())) {
			throw new ConsumerNotFoundException("Consumer Not Found");
		}
		Long propertyValue = calPropertyValue(businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		log.debug("propertyValue : {}", propertyValue);
		Property property = new Property(businessPropertyRequest.getBusinessId(),
				businessPropertyRequest.getConsumerId(), businessPropertyRequest.getInsurancetype(),
				businessPropertyRequest.getPropertytype(), businessPropertyRequest.getBuildingsqft(),
				businessPropertyRequest.getBuildingtype(), businessPropertyRequest.getBuildingstoreys(),
				businessPropertyRequest.getBuildingage(), propertyValue, businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		log.debug("property : {}", property);
		Property propertysave = propertyRepo.save(property);
		log.debug("propertysave : {}", propertysave);
		log.info("End createConsumerBusinessService");
		return "SuccessFully Created Business Property with Property Id: " + propertysave.getId() + " . Thank you!!";
		
	}

	@Override
	public String updateBusinessProperty(BusinessProperty businessPropertyDetails) throws PropertyNotFoundException {
		log.info("Start updateBusinessPropertyService");
		if (!propertyRepo.existsById(businessPropertyDetails.getPropertyId())) {
			throw new PropertyNotFoundException("Property Not Found");
		}

		Property property = propertyRepo.findByConsumerId(businessPropertyDetails.getConsumerId());
		log.debug("property  : {}", property);
		Long propertyValue = calPropertyValue(businessPropertyDetails.getCostoftheasset(),
				businessPropertyDetails.getSalvagevalue(), businessPropertyDetails.getUsefullifeoftheAsset());
		log.debug("propertyValue  : {}", propertyValue);
		property.setInsurancetype(businessPropertyDetails.getInsurancetype());
		property.setPropertytype(businessPropertyDetails.getPropertytype());
		property.setBuildingsqft(businessPropertyDetails.getBuildingsqft());
		property.setBuildingtype(businessPropertyDetails.getBuildingtype());
		property.setBuildingstoreys(businessPropertyDetails.getBuildingstoreys());
		property.setBuildingage(businessPropertyDetails.getBuildingage());
		property.setPropertyvalue(propertyValue);
		property.setCostoftheasset(businessPropertyDetails.getCostoftheasset());
		property.setSalvagevalue(businessPropertyDetails.getSalvagevalue());
		property.setUsefullifeoftheAsset(businessPropertyDetails.getUsefullifeoftheAsset());

		Property propertysave = propertyRepo.save(property);
		log.debug("propertysave  : {}", propertysave);
		log.info("End updateBusinessPropertyService");
		return "SuccessFully Updated Business Property with Property Id :" + propertysave.getId() + " . Thank you!";
	}

	@Override
	public Property viewConsumerProperty(Long consumerid) {
		log.info("Start viewConsumerPropertyService");
		if (!consumerRepo.existsById(consumerid)) {
			new ConsumerNotFoundException("Sorry!!, No Consumer Found!!");
		}
		Property property = propertyRepo.findByConsumerId(consumerid);
		log.debug("property  : {}", property);
		log.info("End viewConsumerPropertyService");
		return property;
	}
	
	

}
