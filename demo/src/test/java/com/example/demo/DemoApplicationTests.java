package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Menu;
import com.example.demo.dao.MenuDao;
import com.example.demo.service.MenuService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MenuService menuService;


	@Test
	public void contextLoads() {
	}
	
	@Test
	public void menuList() {
		List<Menu> list = menuService.findAll();
		//logger.info(list.toString());
		for(Menu m:list) {
			logger.info(m.toString());
		}
	}
	@Test
	public void save() {
		Menu menu = new Menu();
		menu.setMenuName("uuid");
		menuService.save(menu);
	}
	
	@Test
	public void find() {
		System.out.println(menuService.findByid("40288bed64a641a80164a641b6d90000"));
	}

}
