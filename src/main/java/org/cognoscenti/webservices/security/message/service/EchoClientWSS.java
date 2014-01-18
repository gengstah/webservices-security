package org.cognoscenti.webservices.security.message.service;

import java.util.List;
import java.util.LinkedList;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Binding;

import org.cognoscenti.webservices.security.message.service.client.Echo;
import org.cognoscenti.webservices.security.message.service.client.EchoService;

public class EchoClientWSS {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		try {
			
			List<Handler> handlerChain = new LinkedList<Handler>();
			handlerChain.add(new ClientHandler());

			EchoService service = new EchoService();
			Echo port = service.getEchoPort();
			Binding binding = ((BindingProvider) port).getBinding();
			binding.setHandlerChain(handlerChain);

			String response = port.echo("Goodbye, cruel world!");
			System.out.println("From Echo service: " + response);
			
		} catch (Exception ex) { ex.printStackTrace(); }
		
	}
	
}
