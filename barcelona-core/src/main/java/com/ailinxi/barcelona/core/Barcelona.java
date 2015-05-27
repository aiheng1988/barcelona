package com.ailinxi.barcelona.core;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

/**
 * <p>
 * 
 * </p>
 * 
 * @author messi.ai
 *
 */
public class Barcelona {
	
	private Barcelona() {
	}

	private static Barcelona instance;

	public static Barcelona getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new Barcelona();
				}
			}
		}
		return instance;
	}

	public void connect(String host, Integer port) {
		ClientBootstrap client = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));

		try {
			client.setPipelineFactory(new BarcelonaClientPipelineFactory());

			ChannelFuture future = client.connect(new InetSocketAddress(host, port));

			Channel channel = future.sync().getChannel();
			
			channel.getCloseFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			client.releaseExternalResources();
		}
	}

	/**
	 * 返回代理类
	 * 
	 * @param clazz
	 * @param serviceName
	 * @return
	 */
	public <T> T proxy(Class<T> clazz, String serviceName) {
		// TODO Auto-generated method stub
		return null;
	}

}
