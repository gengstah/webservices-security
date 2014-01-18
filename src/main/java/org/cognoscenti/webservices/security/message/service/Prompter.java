package org.cognoscenti.webservices.security.message.service;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import com.sun.xml.wss.impl.callback.PasswordCallback;
import com.sun.xml.wss.impl.callback.UsernameCallback;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prompter implements CallbackHandler {

	private String readLine() {
		
		String line = null;
		
		try {
			
			line = new BufferedReader(new InputStreamReader(System.in)).readLine();
			
		} catch (IOException e) { }
		
		return line;
		
	}
	
	public void handle(Callback[] callbacks) throws UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof UsernameCallback) {
				UsernameCallback cb = (UsernameCallback) callbacks[i];
				System.out.print("Username: ");
				String username = readLine();
				if (username != null) cb.setUsername(username);
			} else if (callbacks[i] instanceof PasswordCallback) {
				PasswordCallback cb = (PasswordCallback) callbacks[i];
				System.out.print("Password: ");
				String password = readLine();
				if (password != null) cb.setPassword(password);
			}
		}
		
	}
	
}