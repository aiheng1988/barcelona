package com.ailinxi.barcelona.test;

import java.io.IOException;

import org.junit.Test;

import com.ailinxi.barcelona.server.BarcelonaServer;

/**
 * <p>
 * 
 * </p>
 * 
 * @author messi.ai
 *
 */
public class EchoTest {
	
	@Test
	public void testLocal() {
		IEcho echo = new Echo();
		String hello = echo.sayHello("ailinxi");
		System.out.println(hello);
	}
	
	@Test
	public void startServer(){
		BarcelonaServer server = BarcelonaServer.getInstance();
		server.start(8999);
		server.register(IEcho.class, Echo.class);
		// TODO
		server.notifyClients();
		// ×èÈû
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
