package org.cognoscenti.webservices.security.message.service;

import javax.xml.ws.Endpoint;
import javax.xml.ws.Binding;
import java.util.List;
import java.util.LinkedList;
import javax.xml.ws.handler.Handler;

public class EchoPublisher {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Endpoint endpoint = Endpoint.create(new Echo());
		Binding binding = endpoint.getBinding();

		List<Handler> handlerChain = new LinkedList<Handler>();
		handlerChain.add(new EchoSecurityHandler());
		binding.setHandlerChain(handlerChain);

		endpoint.publish("http://localhost:7777/echo");
		System.out.println("http://localhost:7777/echo");
		
	}
	
}
