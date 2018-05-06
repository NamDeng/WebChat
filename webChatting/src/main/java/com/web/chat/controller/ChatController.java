package com.web.chat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.chat.persistence.ChatRoomDAO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ChatController {
	
	@Inject
	ChatRoomDAO dao; 
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String moveChatRoom() {
		
		return "chat/usr.chat";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public String makeChatRoom(HttpServletRequest req) {
		
		return "chat/usr.chat";
	}
}
