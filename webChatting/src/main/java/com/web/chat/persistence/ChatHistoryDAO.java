package com.web.chat.persistence;

import com.web.chat.domain.UserHistory;

public interface ChatHistoryDAO {
	
	/**
	 * 채팅방에 들어간다
	 * @param user
	 */
	public void joinByUser(UserHistory user);

	/**
	 * 채팅방을 나간다
	 * @param user
	 */
	public void quitByUser(UserHistory user);
}
