package org.cognoscenti.webservices.security.message.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import com.sun.xml.wss.SubjectAccessor;
import javax.xml.ws.WebServiceContext;
import javax.annotation.Resource;
import com.sun.xml.wss.XWSSecurityException;

@WebService
public class Echo {

	@Resource
	WebServiceContext webserviceContext;

	@WebMethod
	public String echo(String msg) {
		
		String echoValue = null;
		
		try {
			
			echoValue = msg + ": " + SubjectAccessor.getRequesterSubject(webserviceContext);
			
		} catch (XWSSecurityException e) { throw new RuntimeException(e); }
		
		return echoValue;
		
	}
}
