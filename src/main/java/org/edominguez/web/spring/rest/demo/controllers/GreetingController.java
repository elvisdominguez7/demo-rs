package org.edominguez.web.spring.rest.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.edominguez.web.spring.rest.demo.model.Greeting;
import org.edominguez.web.spring.rest.demo.services.GreetingService;


@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService bo;

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();



    @GetMapping("/greeting")
    @ApiOperation(value = "Salute a User.", notes = "Salute a User")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return bo.greet(counter.incrementAndGet(),String.format(template, name));

    }

}
