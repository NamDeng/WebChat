package com.web.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.chat.domain.ChatRoom;
import com.web.chat.domain.UserHistory;
import com.web.chat.persistence.ChatRoomDaoImpl;

@Service("chatRoomService")
public class ChatRoomService {

	@Autowired
	ChatRoomDaoImpl chatRoomDao;
	
	public void makeChatRoom(String title, String nickName) {
		final ChatRoom room = new ChatRoom.Builder()
			.title(title).build();
		chatRoomDao.make(room);
		
		final UserHistory user = new UserHistory.Builder()
			.nickName(nickName)
			.roomId(room.getRoomId()).build();
		chatRoomDao.join(user);
	}
	
	public List<ChatRoom> getCurrentChatRoomList() {
		return chatRoomDao.getListAll();
	}
}
