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
		final ChatRoom room = new ChatRoom.Builder().title(title).build();
		chatRoomDao.make(room);
		
		return room;
	}
	
	public UserHistory joinChatRoom(String nickName, int avatarType, long roomId) {
		final UserHistory user = new UserHistory.Builder()
				.nickName(nickName).roomId(roomId).avatarType(avatarType).build();
		chatRoomDao.join(user);

		return user;
	}
	
	public List<ChatRoom> getCurrentChatRoomList() {
		return chatRoomDao.getListAll();
	}
	
	public List<UserHistory> getUserListInChatRoom(long roomId) {
		return chatRoomDao.getUserListInChatRoom(roomId);
	}
	
	public ChatRoom getCurrentChatRoom(long roomId) {
		return chatRoomDao.getCurrentChatRoom(roomId);
	}
}
