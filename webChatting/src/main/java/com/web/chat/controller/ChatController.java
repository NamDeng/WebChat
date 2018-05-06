package com.web.chat.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		logger.info("count : " + dao.makeChatRoom());
		
		return "chat/usr.chat";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public String makeChatRoom(HttpServletRequest req) {
		
		logger.info("/chat in post");
		logger.info("parameter is " + req.getParameter("title"));
		logger.info("parameter is " + req.getParameter("nickName"));
		logger.info("parameter is " + req.getParameter("avatar"));
		
		return "chat/usr.chat";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/chatting", method = RequestMethod.GET)
	public ModelAndView chatTogether(ModelAndView model) {
		
		logger.info("/chatting in get");
		model.addObject("serverTime", "asdfasdf");
		model.setViewName("chat/usr.chat");
		
		return model;
	}
}
