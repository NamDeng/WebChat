package com.web.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.chat.domain.UserHistory;
import com.web.chat.persistence.ChatHistoryDAOImpl;

@Service("chatHistoryService")
public class ChatHistoryService {

	@Autowired
	ChatHistoryDAOImpl chatHistoryDao;
	
	public UserHistory joinChatRoom(String nickName, int avatarType, long roomId) {
		final UserHistory user = UserHistory.builder().nickName(nickName).roomId(roomId).avatarType(avatarType).build();
		chatHistoryDao.joinByUser(user);

		return user;
	}
	
	public void quitChatRoom(UserHistory user) {
		chatHistoryDao.quitByUser(user);
	}
}
