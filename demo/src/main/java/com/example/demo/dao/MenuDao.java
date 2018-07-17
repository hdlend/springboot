package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Menu;

public interface MenuDao extends JpaRepository<Menu,String>{
	
	public Menu findByMenuid(String id);
		
	

}
