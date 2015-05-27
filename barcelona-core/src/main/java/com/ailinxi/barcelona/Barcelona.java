package com.ailinxi.barcelona;

/**
 * <p>
 * 
 * </p>
 * 
 * @author messi.ai
 *
 */
public class Barcelona {
	
	private Barcelona(){}
	
	private static Barcelona instance;
	
	public static Barcelona getInstance(){
		if(instance != null) {
			synchronized (instance) {
				if(instance != null) {
					instance = new Barcelona();
				}
			}
		}
		return instance;
	}

	public void config(String server, Integer port) {
		
	}

	/**
	 * 返回代理类
	 * @param clazz
	 * @param serviceName
	 * @return
	 */
	public <T> T proxy(Class<T> clazz, String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

}
