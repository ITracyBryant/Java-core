package com.sk.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Msg_Server.Change_WGS;

public class File_read {
	private Change_WGS cWgs=new Change_WGS();
	public List<String> getLon_Lat(String filename){
		File file=new File(filename);
		BufferedReader reader=null;
		List<String> mList=new ArrayList<String>();
		try {
			reader=new BufferedReader(new FileReader(file));
			String msg="";
			
			String Lon_Lat="";
			int index=1;
			while((msg=reader.readLine())!=null){
				Double lonString=Double.parseDouble(msg.split(";")[4].split(":")[1]);
				Double latString=Double.parseDouble(msg.split(";")[5].split(":")[1]);
				//System.out.println(lonString+";"+latString);
				double[] l = cWgs.wgs2bd(latString, lonString);
				lonString=l[1];
				latString=l[0];
				mList.add(lonString.toString());
				mList.add(latString.toString());
			}
			return mList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return mList;
	}
	public static void main(String[] args) {
		File_read read=new File_read();
		List<String> lon_Lat = read.getLon_Lat("E:/13262880098/2018_04_24_18_19_55.txt");
		for (String string : lon_Lat) {
			System.out.println(string);
		}
	}
}
