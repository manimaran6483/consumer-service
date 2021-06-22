package com.consumer.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class ConsumerBusinessDetailsTests {

	ConsumerBusiness consumerBusinessDetails;
	
	
	@Test
    public void testConsumerBusinessDetails() throws Exception {
		consumerBusinessDetails=new ConsumerBusiness();
		consumerBusinessDetails.setAgentid((long)1);
		consumerBusinessDetails.setAgentname("test");
		consumerBusinessDetails.setBusinessage((long)1);
		consumerBusinessDetails.setBusinesscategory("test");
		consumerBusinessDetails.setBusinessname("test");
		consumerBusinessDetails.setBusinessoverview("test");
		consumerBusinessDetails.setBusinessturnover((long)1);
		consumerBusinessDetails.setBusinesstype("test");
		consumerBusinessDetails.setCapitalinvested((long)1);
		consumerBusinessDetails.setDob("test");
		consumerBusinessDetails.setEmail("test");
		consumerBusinessDetails.setFirstname("test");
		consumerBusinessDetails.setLastname("test");
		consumerBusinessDetails.setPandetails("test");
		consumerBusinessDetails.setPhone("test");
		consumerBusinessDetails.setTotalemployees((long)1);
		consumerBusinessDetails.setValidity("test");
		consumerBusinessDetails.setWebsite("test");
		consumerBusinessDetails.setBusinessid((long)1);
		consumerBusinessDetails.setConsumerId((long)1);
		consumerBusinessDetails.setBusinessvalue((long)1);
		assertEquals((long)1,consumerBusinessDetails.getAgentid());
		assertEquals("test",consumerBusinessDetails.getAgentname());
		assertEquals((long)1,consumerBusinessDetails.getBusinessage());
		assertEquals("test",consumerBusinessDetails.getBusinesscategory());
		assertEquals("test",consumerBusinessDetails.getBusinessname());
		assertEquals("test",consumerBusinessDetails.getBusinessoverview());
		assertEquals((long)1,consumerBusinessDetails.getBusinessturnover());
		assertEquals("test",consumerBusinessDetails.getBusinesstype());
		assertEquals((long)1,consumerBusinessDetails.getCapitalinvested());
		assertEquals("test",consumerBusinessDetails.getDob());
		assertEquals("test",consumerBusinessDetails.getEmail());
		assertEquals("test",consumerBusinessDetails.getFirstname());
		assertEquals("test",consumerBusinessDetails.getLastname());
		assertEquals("test",consumerBusinessDetails.getPandetails());
		assertEquals("test",consumerBusinessDetails.getPhone());
		assertEquals((long)1,consumerBusinessDetails.getTotalemployees());
		assertEquals("test",consumerBusinessDetails.getValidity());
		assertEquals("test",consumerBusinessDetails.getWebsite());
		assertEquals((long)1,consumerBusinessDetails.getBusinessid());
		assertEquals((long)1,consumerBusinessDetails.getConsumerId());
		assertEquals((long)1,consumerBusinessDetails.getBusinessvalue());
	}
	
	@Test
    public void testConsumerBusinessDetailsConstructor() throws Exception {
		consumerBusinessDetails=new ConsumerBusiness("test","test","test","test","test","test","test","test","test","test","test",(long)1,(long)1,(long)1,"test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,consumerBusinessDetails.getAgentid());
		assertEquals("test",consumerBusinessDetails.getAgentname());
		assertEquals((long)1,consumerBusinessDetails.getBusinessage());
		assertEquals("test",consumerBusinessDetails.getBusinesscategory());
		assertEquals("test",consumerBusinessDetails.getBusinessname());
		assertEquals("test",consumerBusinessDetails.getBusinessoverview());
		assertEquals((long)1,consumerBusinessDetails.getBusinessturnover());
		assertEquals("test",consumerBusinessDetails.getBusinesstype());
		assertEquals((long)1,consumerBusinessDetails.getCapitalinvested());
		assertEquals("test",consumerBusinessDetails.getDob());
		assertEquals("test",consumerBusinessDetails.getEmail());
		assertEquals("test",consumerBusinessDetails.getFirstname());
		assertEquals("test",consumerBusinessDetails.getLastname());
		assertEquals("test",consumerBusinessDetails.getPandetails());
		assertEquals("test",consumerBusinessDetails.getPhone());
		assertEquals((long)1,consumerBusinessDetails.getTotalemployees());
		assertEquals("test",consumerBusinessDetails.getValidity());
		assertEquals("test",consumerBusinessDetails.getWebsite());
		assertEquals((long)1,consumerBusinessDetails.getBusinessid());
		assertEquals((long)1,consumerBusinessDetails.getConsumerId());
	}
}