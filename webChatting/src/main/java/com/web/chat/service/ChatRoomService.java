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

	public ChatRoom makeChatRoom(String title) {
		final ChatRoom room = ChatRoom.builder().title(title).build();
		chatRoomDao.makeChatRoom(room);

		return room;
	}

	public ChatRoom getUsingChatRoom(long roomId) {
		return chatRoomDao.getUsingChatRoom(roomId);
	}

	public List<ChatRoom> getUsingChatRoomList() {
		return chatRoomDao.getUsingChatRoomList();
	}

	public List<UserHistory> getUserListInChatRoom(long roomId) {
		return chatRoomDao.getUserListInChatRoom(roomId);
	}

}
