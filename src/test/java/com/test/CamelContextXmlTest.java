package com.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redhat.empowered.businessservice.Person;
import com.redhat.empowered.businessservice.QueryPerson;

public class CamelContextXmlTest extends CamelSpringTestSupport {

	// TODO Create test message bodies that work for the route(s) being tested
	// Expected message bodies
	protected Object[] expectedBodies = { "<something id='1'>expectedBody1</something>",
			"<something id='2'>expectedBody2</something>" };
	// Templates to send to input endpoints
	
	
	@Produce(uri = "ref:test")
	protected ProducerTemplate inputEndpoint;

	@Test
	public void testCamelRoute() throws Exception {

		// Define some expectations

		// For now, let's just wait for some messages// TODO Add some expectations here
		// Send some messages to input endpoints
		QueryPerson queryPerson = new QueryPerson();
		queryPerson.setId("TEST_PERSON_NAME");
		Person p = (Person) ((MessageContentsList)inputEndpoint.requestBody(queryPerson)).get(0);
		// Validate our expectations
		assertEquals("TEST_PERSON_NAME", p.getId());
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

}
