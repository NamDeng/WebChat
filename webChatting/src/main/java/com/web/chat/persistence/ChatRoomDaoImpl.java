package com.web.chat.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.chat.domain.ChatRoom;
import com.web.chat.domain.UserHistory;

@Repository
public class ChatRoomDaoImpl implements ChatRoomDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.web.chat.mapper.chatRoomMapper";

	@Override
	public void makeChatRoom(ChatRoom room) {
		sqlSession.insert(namespace + ".makeChatRoom", room);
	}
	
	@Override
	public ChatRoom getUsingChatRoom(long roomId) {
		return sqlSession.selectOne(namespace + ".getUsingChatRoom", roomId);
	}

	@Override
	public List<ChatRoom> getUsingChatRoomList() {
		return sqlSession.selectList(namespace + ".getUsingChatRoomList");
	}

	@Override
	public List<UserHistory> getUserListInChatRoom(long roomId) {
		return sqlSession.selectList(namespace + ".getUserListInChatRoom", roomId);
	}
}
