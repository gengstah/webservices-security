
package org.cognoscenti.webservices.security.message.service.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Echo", targetNamespace = "http://service.message.security.webservices.cognoscenti.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Echo {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "echo", targetNamespace = "http://service.message.security.webservices.cognoscenti.org/", className = "org.cognoscenti.webservices.security.message.service.client.Echo_Type")
    @ResponseWrapper(localName = "echoResponse", targetNamespace = "http://service.message.security.webservices.cognoscenti.org/", className = "org.cognoscenti.webservices.security.message.service.client.EchoResponse")
    @Action(input = "http://service.message.security.webservices.cognoscenti.org/Echo/echoRequest", output = "http://service.message.security.webservices.cognoscenti.org/Echo/echoResponse")
    public String echo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
