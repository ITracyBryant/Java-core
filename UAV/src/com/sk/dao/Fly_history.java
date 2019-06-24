package com.sk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sk.annoation.IDao;

import entity.Test_uva_info;

@IDao
public interface Fly_history {
	public List<Test_uva_info> findAll(@Param("tablename") String tablename);
}
