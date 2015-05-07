package com.webService.SEI;

import javax.jws.WebService;

/*
 * SEI的实现
 */
@WebService
public class HelloWSImpl implements HelloWS {

	@Override
	public String sayHello(String name) {
		System.out.println("Server  sayHello() arg== " + name); 
		System.out.println("return =="+"Hello " + name);
		return "Hello " + name;
	}

}
