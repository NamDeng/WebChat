package com.web.chat.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.web.chat.domain.ChatRoom;
import com.web.chat.domain.UserHistory;
import com.web.chat.service.ChatHistoryService;
import com.web.chat.service.ChatRoomService;

/**
 * Handles requests for the application home page.
 */

@RestController
@SessionAttributes("currentUser")
@RequestMapping(value = "/chat")
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Resource(name="chatRoomService")
	ChatRoomService chatRoomService;
	
	@Resource(name="chatHistoryService")
	ChatHistoryService chatHistoryService;

	@GetMapping("")
	public ModelAndView home() {
		final ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("roomList", chatRoomService.getUsingChatRoomList());
		return mav;
	}

	@PostMapping("/room")
	public ModelAndView makeChatRoom(
			@RequestParam("title") String title,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType) {

		final ChatRoom room = chatRoomService.makeChatRoom(title);
		final UserHistory user = chatHistoryService.joinChatRoom(nickName, avatarType, room.getRoomId());
		final List<UserHistory> userList = chatRoomService.getUserListInChatRoom(room.getRoomId());
		
		final ModelAndView mav = new ModelAndView("chat/usr.chat");
		mav.addObject("room", room);
		mav.addObject("currentUser", user);
		mav.addObject("userList", userList);
		
		if(logger.isInfoEnabled())
			logger.info("make {} chatroom.", title);
		
		return mav;
	}
	
	@PostMapping("/room/{roomId}")
	public ModelAndView joinChatRoom(
			@PathVariable Long roomId,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType) {

		final ChatRoom room = chatRoomService.getUsingChatRoom(roomId);
		final UserHistory user = chatHistoryService.joinChatRoom(nickName, avatarType, roomId);
		final List<UserHistory> userList = chatRoomService.getUserListInChatRoom(roomId);

		final ModelAndView mav = new ModelAndView("chat/usr.chat");
		mav.addObject("room", room);
		mav.addObject("currentUser", user);
		mav.addObject("userList", userList);

		if(logger.isInfoEnabled()) 
			logger.info("join chatroom. nickName : {}", nickName);
		
		return mav;
	}
	
	@DeleteMapping("/room/user")
	public ModelAndView quitChatRoom(@RequestBody UserHistory user) {

		System.out.println("in quitChatRoom....");
//		final ChatRoom room = chatRoomService.getUsingChatRoom(roomId);
//		final List<UserHistory> userList = chatRoomService.getUserListInChatRoom(roomId);
		chatHistoryService.quitChatRoom(user);
		
		final ModelAndView mav = new ModelAndView("chat/usr.chat");
//		mav.addObject("room", room);
//		mav.addObject("currentUser", user);
//		mav.addObject("userList", userList);

		if(logger.isInfoEnabled()) 
			logger.info("quit chatroom. nickName : {}", user.getNickName());
		
		return mav;
	}
}
