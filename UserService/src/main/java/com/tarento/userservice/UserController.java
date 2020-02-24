package com.tarento.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

	 @Autowired
	 RestTemplate restTemplate;
	 
	 
	@RequestMapping(value = "/user/getBook/{writerName}", method = RequestMethod.GET)
	public String get(@PathVariable String writerName) {
		
		 String response = restTemplate.exchange("http://catalog-service/getBook/{writerName}",
                 HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, writerName).getBody();

		 System.out.println("Response Received as " + response);

		 return "Writer Name -  " + writerName + " \n Book Details " + response;
		
	
	}
	
	
	 @Bean
	 @LoadBalanced
	  public RestTemplate restTemplate() {
	        return new RestTemplate();
	  }
}
