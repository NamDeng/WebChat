package com.web.chat.persistence;

import com.web.chat.domain.ChatRoom;
import com.web.chat.domain.UserHistory;

public interface ChatRoomDAO {

	
	/**
	 * 채팅방을 만든다
	 */
	public void make(ChatRoom room);
	
	/**
	 * 채팅방에 들어간다
	 * @param user
	 */
	public void join(UserHistory user);
	
	/**
	 * 채팅방을 나간다
	 * @param user
	 */
	public void quit(UserHistory user);
}
