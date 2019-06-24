package com.sk.init;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Msg_Server.Msg_Sever;

public class StartInit implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Msg_Sever sever=new Msg_Sever();
				sever.start();
			}
		});
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Start_ScanClasses scanClasses=new Start_ScanClasses();
				scanClasses.start();
				
			}
		});
		thread.start();
		thread2.start();
		
		
		
	}

}
