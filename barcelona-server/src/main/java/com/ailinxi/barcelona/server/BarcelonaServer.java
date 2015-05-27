package com.ailinxi.barcelona.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * <p>
 * 
 * </p>
 * 
 * @author messi.ai
 *
 */
public class BarcelonaServer {
	
	private BarcelonaServer(){}
	
	private static BarcelonaServer instance;

	public static BarcelonaServer getInstance() {
		if(instance == null) {
			synchronized (BarcelonaServer.class) {
				if(instance == null) {
					instance = new BarcelonaServer();
				}
			}
		}
		return instance;
	}

	/**
	 * 开启服务
	 * @param port 监听端口
	 */
	public void start(int port) {
		ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setOption("child.tcpNoDelay", true);

        bootstrap.setPipelineFactory(new BarcelonaServerPipelineFactory());

        bootstrap.bind(new InetSocketAddress(port));
	}

	public <T> void register(Class<T> iclazz, Class<? extends T> clazz) {
		// TODO Auto-generated method stub
		
	}

	public void notifyClients() {
		// TODO Auto-generated method stub
		
	}

}
