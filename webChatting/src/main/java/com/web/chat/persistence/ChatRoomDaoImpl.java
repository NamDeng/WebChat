package com.web.chat.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.chat.domain.ChatUser;

@Repository
public class ChatRoomDaoImpl implements ChatRoomDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.web.chat.mapper.chatMapper";

	@Override
	public void makeChatRoom() {
	}

	@Override
	public void joinChatRoom(ChatUser user) {
		
	}

	@Override
	public void quitChatRoom(ChatUser user) {
	}
}
