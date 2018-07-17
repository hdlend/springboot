package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.Menu;
import com.example.demo.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping(value="/menuList")
	@ResponseBody
	public List<Menu> menuList() {
		return menuService.findAll();
	}
	
	@GetMapping(value="/pageList")
	@ResponseBody
	public List<Menu> pageList() {
		return menuService.findMenuByPage();
	}

}
