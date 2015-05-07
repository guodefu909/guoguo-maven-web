package com.webService.publish;

import javax.xml.ws.Endpoint;

import com.webService.SEI.HelloWSImpl;

/*
 * 发布Web Service
 */
public class serverPublish {
	
	public static void main(String[] args) {
	    
		String address = "http://10.236.0.130:8989/hellows";
		Endpoint.publish(address,new HelloWSImpl());
		System.out.println("发布webservice成功！");
    }
}
