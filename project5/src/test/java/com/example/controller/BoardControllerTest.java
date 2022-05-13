package com.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@WebAppConfiguration
@ContextConfiguration(classes = { com.example.config.RootConfig.class, com.example.config.ServletConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class BoardControllerTest {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register").param("title", "테스트 새 제목")
						.param("content", "테스트 새 내용").param("writer", "테스트 새 유저"))
				.andReturn().getModelAndView().getViewName();
		// Exception이 필요한 이유 ^
		log.info(resultPage);
	}

//	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn()
				.getModelAndView().getModelMap());
	}
	
//	@Test
	public void testModify() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "1").param("title", "테스트 수정 제목")
						.param("content", "테스트 수정 내용").param("writer", "테스트 수정 유저"))
				.andReturn().getModelAndView().getViewName();
		// Exception이 필요한 이유 ^
		log.info(resultPage);
	}
	
//	@Test
	public void testRemove() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "6"))
				.andReturn().getModelAndView().getViewName();
		// Exception이 필요한 이유 ^
		log.info(resultPage);
	}
	
	@Test
	public void testlistPaging() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.get("/board/list").param("pageNum", "2").param("amount", "5"))
				.andReturn().getModelAndView().getViewName();
		// Exception이 필요한 이유 ^
		log.info(resultPage);
	}
}
