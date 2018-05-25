package com.web.chat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ChatControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ChatControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		logger.info("setupt.......");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void MakeChatRoomTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/chat/room")
				.param("title", "채팅방입니다.11")
				.param("nickName", "가나다라마바사zeze")
				.param("avatar", "on"));
	}
	
	@Test
	public void joinChatRoomTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/chat/room/12")
				.param("nickName", "익명123123")
				.param("avatar", "on"));
	}
}
