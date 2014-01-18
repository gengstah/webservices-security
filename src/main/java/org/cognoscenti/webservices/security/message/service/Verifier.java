package org.cognoscenti.webservices.security.message.service;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

public class Verifier implements CallbackHandler {

	private static final String USERNAME = "fred";
	private static final String PASSWORD = "rockbed";

	public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
		
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof PasswordValidationCallback) {
				PasswordValidationCallback cb = (PasswordValidationCallback) callbacks[i];
				if (cb.getRequest() instanceof PasswordValidationCallback.PlainTextPasswordRequest)
					cb.setValidator(new PlainTextPasswordVerifier());
			} else throw new UnsupportedCallbackException(null, "Not needed");
			
		}
		
	}

	private class PlainTextPasswordVerifier implements PasswordValidationCallback.PasswordValidator {

		public boolean validate(PasswordValidationCallback.Request request) 
				throws PasswordValidationCallback.PasswordValidationException {

			PasswordValidationCallback.PlainTextPasswordRequest plainPassword = 
					(PasswordValidationCallback.PlainTextPasswordRequest) request;
			if (USERNAME.equals(plainPassword.getUsername()) && PASSWORD.equals(plainPassword.getPassword())) return true;
			else return false;
			
		}
		
	}
}
