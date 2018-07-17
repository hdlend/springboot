package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "menu")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Menu {
	
	@Id
//	@GeneratedValue(generator = "jpa-uuid")
	@GenericGenerator(name="idGenerator", strategy="uuid") 
    @GeneratedValue(generator="idGenerator")
    @Column(length = 32)
	private String menuid;
	
	private String menuName;
	
	public Menu(){}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuName=" + menuName + "]";
	};
	
	

}
