package com.web.controller;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.Person;

@Controller
@RequestMapping(value = "/autoComplete")
public class AutoCompleteController {

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	public Person[] getUser() {
		Person[] persons = new Person[5];
		for(int i = 0; i<persons.length; i++ ){
			persons[i] = new Person(i,i+"Person");
		}
		return persons;
	}

	
	
}
