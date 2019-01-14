package org.edominguez.web.spring.rest.demo.services;

import org.edominguez.web.spring.rest.demo.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	private Greeting greeting;
	
	
	public Greeting greet(long id, String content) {
		greeting = new Greeting(id,content);
		return greeting;
		
	}

}
