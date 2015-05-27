package com.ailinxi.barcelona.test;

import org.junit.Test;
import com.ailinxi.barcelona.core.Barcelona;

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
	public void testRemote(){
		Barcelona server = Barcelona.getInstance();
		server.connect("localhost", 8999);
		IEcho echo = server.proxy(IEcho.class, "com.ailinxi.barcelona.test.Echo");
		String hello = echo.sayHello("ailinxi");
		System.out.println(hello);
	}

}
