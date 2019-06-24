package com.sk.init;

import java.util.Date;

import message.Scan_No_fly_endTime;
import message.Scan_Noflu_Number;

public class Start_ScanClasses {
	private Scan_No_fly_endTime no_fly_endTime=new Scan_No_fly_endTime();
	private Scan_Noflu_Number scan_Noflu_Number=new Scan_Noflu_Number();
	public void start(){
		Thread thread=new Thread(new Scan_Init());
			thread.start();
	}
	class Scan_Init implements Runnable{
		
		@Override
		public void run() {
			while((new Date()).getTime()%60000==0){
				no_fly_endTime.fly_endtime();
				scan_Noflu_Number.bofly_number();
			}
			
		}
		
	}

}
