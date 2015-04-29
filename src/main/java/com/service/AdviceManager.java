package com.service;


import org.springframework.stereotype.Component;

@Component
public class AdviceManager {

	public String toBeAdvice() {
		System.out.println("toBeAdvice");
		return "returnValue";
	}

	// public void throwingException() {
	// try{
	// int a = 10/0;
	// }
	// catch(ArithmeticException ae){
	// System.out.println("除数为0异常已被处理");
	// }
	// String s = null;
	// System.out.println(s.substring(0,3));
	// }

	public String toBeAround(String param1,String param2) {
		System.out.println("toBeAround");
		return param1+param2;
	}

}
