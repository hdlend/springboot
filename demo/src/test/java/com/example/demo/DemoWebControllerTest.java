package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class DemoWebControllerTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before() 
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }
    @Test
    public void getAllMenu() throws Exception {
        String responseString = mockMvc.perform(
                get("/menuList")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)  //数据的格式
                       // .param("pcode","root")         //添加参数
        ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }
    @Test
    public void getPageMenu() throws Exception {
    	String responseString = mockMvc.perform(
    			get("/pageList")    //请求的url,请求的方法是get
    			.contentType(MediaType.APPLICATION_JSON)  //数据的格式
    			// .param("pcode","root")         //添加参数
    			).andExpect(status().isOk())    //返回的状态是200
    			.andDo(print())         //打印出请求和相应的内容
    			.andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
    	System.out.println("--------返回的json = " + responseString);
    }

}
