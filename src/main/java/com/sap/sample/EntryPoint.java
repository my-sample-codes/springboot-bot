/**
 * 
 */
package com.sap.sample;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sap.sample.service.impl.SampleServiceImpl;

/**
 * @author rmoha9
 *
 */
@SpringBootApplication(scanBasePackages = { "com.sap.sample" })
public class EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

	@Autowired
	private Bus bus;

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		endpoint.setServiceBeans(Arrays.<Object>asList(new SampleServiceImpl()));
		return endpoint.create();
	}

	public static void main(String[] args) {
		try {
			LOGGER.info("Server starting at http://localhost:8080......");
			SpringApplication.run(EntryPoint.class, args);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
		}
	}
}
