package com.sk.dao;

import java.util.List;

import com.sk.annoation.IDao;

import entity.Fly_plan;

@IDao
public interface Fly_plan_dao {
	public void save(Fly_plan fly_plan);
	public void update(Fly_plan fly_plan);
	public List<Fly_plan> findAll();
	public List<Fly_plan> findByName(String username);
	public List<Fly_plan> find();
}
