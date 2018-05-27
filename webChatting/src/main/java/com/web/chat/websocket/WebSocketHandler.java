package com.web.chat.websocket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocketHandler 인터페이스 메소드 구현
 */
public class WebSocketHandler extends TextWebSocketHandler {

	private List<WebSocketSession> sessionList = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

	/**
	 * 클라이언트 연결
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		
		System.out.println("[websocket] client connection. : " + session.getId());
		logger.info("[websocket] client connection. id : {}", session.getId());
	}
	
	/**
	 * 텍스트 메세지 전송
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("{} client text message send : {}", session.getId(), message.getPayload());
		System.out.println("send message. : " + message.getPayload());
		
		System.out.println();
//		for (WebSocketSession webSocketSession : sessionList) {
//			webSocketSession.sendMessage(new TextMessage(session.getPrincipal().getName() + "|" + message.getPayload()));
//		}
		session.sendMessage(new TextMessage(session.getPrincipal().getName() + "|" + message.getPayload()));
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
		sessionList.remove(session);
		System.out.println("[websocket] client connection. : " + session.getId());
		logger.info("{} client disconnect.", session.getId());
	}
}
