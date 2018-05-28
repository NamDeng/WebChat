package com.web.chat.websocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.chat.domain.Message;

/**
 * WebSocketHandler 인터페이스 메소드 구현
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

	private final Map<Long, List<WebSocketSession>> roomMap;
	private final Map<String, WebSocketSession> sessionMap;
	private final ObjectMapper objectMapper;

	public WebSocketHandler() {
		this.objectMapper = new ObjectMapper();
		this.roomMap = new HashMap<>();
		this.sessionMap = new HashMap<>(); 
	}
	
	/**
	 * 클라이언트 연결
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionMap.put(session.getId(), session);
		
		System.out.println("[websocket] client connection. : " + session.getId());
		logger.info("[websocket] client connection. id : {}", session.getId());
	}
	
	/**
	 * 텍스트 메세지 전송
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		final String payload = message.getPayload();
		final Message msg = objectMapper.readValue(payload, Message.class);
		
		if (msg.getType().equals("send")) {
			sendMessage(msg);
		} else if(msg.getType().equals("join")) {
			setMessageTarget(msg, session);
		}
	}
	
	/**
	 * 메세지 전송 에러
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	}

	/**
	 * 클라이언트와 연결 종료
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionMap.remove(session.getId());
	}
	
	/**
	 * 채팅방 그룹 설정
	 * @param msg
	 * @param session
	 */
	private void setMessageTarget(final Message msg, WebSocketSession session) {
		List<WebSocketSession> group = null;
		if(isExistGroup(msg)) {
			group = getExistGroup(msg);
		} else {
			group = getNewGroup();
		}
		group.add(session);
		roomMap.put(msg.getRoomId(), group);
	}

	/**
	 * 
	 * @param msg
	 * @param session
	 */
	private List<WebSocketSession> getExistGroup(final Message msg) {
		return roomMap.get(msg.getRoomId());
	}

	/**
	 * 
	 * @param msg
	 * @param session
	 */
	private List<WebSocketSession> getNewGroup() {
		return new ArrayList<WebSocketSession>();
	}

	/**
	 * 채팅방 그룹 생성 여부
	 * @param msg
	 * @return
	 */
	private boolean isExistGroup(final Message msg) {
		return roomMap.containsKey(msg.getRoomId());
	}
	
	/**
	 * 채팅방별 메세지 전송
	 * @param msg
	 * @throws Exception
	 */
	private void sendMessage(final Message msg) throws Exception {
		final List<WebSocketSession> group = getMessageGroup(msg.getRoomId());
		
		for (WebSocketSession webSocketSession : group) {
			if(webSocketSession.isOpen()) {
				webSocketSession.sendMessage(new TextMessage(msg.getMessage()));
			}
		}
	}

	/**
	 * 메세지 전송 대상 목록을 가져온다.
	 * @param roomId
	 * @return
	 */
	private List<WebSocketSession> getMessageGroup(long roomId) {
		return roomMap.get(roomId);
	}
}
