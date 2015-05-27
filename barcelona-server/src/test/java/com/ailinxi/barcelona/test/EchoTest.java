package com.ailinxi.barcelona.test;

import org.junit.Test;

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

}
