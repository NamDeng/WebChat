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
	public void make(ChatRoom room) {
		sqlSession.insert(namespace + ".makeChatRoom", room);
	}

	@Override
	public void join(UserHistory user) {
		sqlSession.insert(namespace + ".joinUser", user);
	}

	@Override
	public void quit(UserHistory user) {
	}

	@Override
	public List<ChatRoom> getListAll() {
		return sqlSession.selectList(namespace + ".getListAll");
	}
}
