package com.sk.test;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sk.dao.Ad_info_dao;
import com.sk.dao.Ad_uva_list_dao;
import com.sk.dao.Fly_history;
import com.sk.dao.Nofly_number_dao;
import com.sk.dao.U_uva_info_dao;

import entity.Ad_info;
import entity.Ad_uva_list;
import entity.Nofly_number;
import entity.Test_uva_info;

public class Database_connection_test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Fly_history dao = context.getBean("fly_history",Fly_history.class);
		List<Test_uva_info> history = dao.findAll("u13262880098");
		
	}

}
