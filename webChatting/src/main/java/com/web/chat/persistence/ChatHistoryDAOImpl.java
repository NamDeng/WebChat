package com.web.chat.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.chat.domain.UserHistory;

@Repository
public class ChatHistoryDAOImpl implements ChatHistoryDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.web.chat.mapper.chatHistoryMapper";
	
	@Override
	public void joinByUser(UserHistory user) {
		sqlSession.insert(namespace + ".joinByUser", user);
	}

	@Override
	public void quitByUser(UserHistory user) {
	}

}
