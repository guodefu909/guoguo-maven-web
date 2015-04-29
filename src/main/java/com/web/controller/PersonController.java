package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.Person;

@Controller
public class PersonController {

	@RequestMapping(value = "person/profile/{id}/{name}/{status}", method = RequestMethod.GET)
	@ResponseBody
	public Person porfile(@PathVariable int id,@PathVariable String name,@PathVariable boolean status) {
		return new Person(id, name, status);
	}

	@RequestMapping(value = "person/login", method = RequestMethod.POST)
	@ResponseBody
	public Person login(@RequestBody Person person) {// @RequestBody与@ResponseBody的作用非常明显
		System.out.println(person.getName());
		return person;
	}
}
