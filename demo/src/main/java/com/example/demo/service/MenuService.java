package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Menu;
import com.example.demo.dao.MenuDao;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	public void save(Menu menu) {
		menuDao.save(menu);
	}
	
	public List<Menu> findAll(){
		return menuDao.findAll();
	}
	
	public Menu findByid(String id){
		return menuDao.findByMenuid(id);
	}
	
	public List<Menu> findMenuByPage(){
		 Sort sort = new Sort(Direction.DESC, "menuid");
		 Pageable pageable =  PageRequest.of(0, 10);
	     Page<Menu> pages= menuDao.findAll(pageable);
	     return pages.getContent();
	}

}
