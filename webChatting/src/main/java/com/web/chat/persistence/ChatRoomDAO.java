package com.web.chat.persistence;

import com.web.chat.domain.ChatUser;

public interface ChatRoomDAO {

	
	// 채팅방을 생성한다.
	public void makeChatRoom();
	
	// 채팅방으로 사용자가 들어온다
	public void joinChatRoom(ChatUser user);
	
	// 채팅방에서 사용자가 나간다.
	public void quitChatRoom(ChatUser user);
}
