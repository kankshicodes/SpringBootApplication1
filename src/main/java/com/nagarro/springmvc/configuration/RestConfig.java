/**
 * 
 */
package com.nagarro.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This class is use for configuration the RestTemplate propertie
 * @author ravikumar05
 *
 */
@Configuration
public class RestConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
