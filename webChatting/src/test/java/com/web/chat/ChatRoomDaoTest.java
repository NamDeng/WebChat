package com.web.chat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.web.chat.domain.ChatRoom;
import com.web.chat.persistence.ChatRoomDAO;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ChatRoomDaoTest {

	@Autowired
	private ChatRoomDAO dao;
	
	@Test
	public void getChatRoomListAll() {
		List<ChatRoom> rooms = dao.getListAll();
		for (ChatRoom chatRoom : rooms) {
			System.out.println(chatRoom.getTitle());
		}
	}

}
