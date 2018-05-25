package com.web.chat.persistence;

import java.util.List;

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
	
	/**
	 * 개설된 채팅방 목록을 가져온다.
	 * @param user
	 * @return 
	 */
	public List<ChatRoom> getListAll();
	
	/**
	 * 채팅방 접속인원 리스트를 가져온다.
	 * @return
	 */
	public List<UserHistory> getUserListInChatRoom(long roomId);

	/**
	 * 현재 채팅방 정보를 가져온다.
	 * @return
	 */
	public ChatRoom getCurrentChatRoom(long roomId);
}
