package com.web.chat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.web.chat.domain.ChatRoom;
import com.web.chat.domain.UserHistory;
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

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("roomList", chatRoomService.getCurrentChatRoomList());
		return mv;
	}

	@PostMapping("/room")
	public ModelAndView makeChatRoom(
			@RequestParam("title") String title,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType) {

		ChatRoom room = chatRoomService.makeChatRoom(title);
		UserHistory user = chatRoomService.joinChatRoom(nickName, avatarType, room.getRoomId());
		List<UserHistory> userList = chatRoomService.getUserListInChatRoom(room.getRoomId());
		
		final ModelAndView mv = new ModelAndView("chat/usr.chat");
		mv.addObject("currentUser", user);
		mv.addObject("userList", userList);
		return mv;
	}
	
	@PostMapping("/room/{roomId}")
	public ModelAndView joinChatRoom(
			@PathVariable Long roomId,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType) {

		UserHistory user = chatRoomService.joinChatRoom(nickName, avatarType, roomId);
		List<UserHistory> userList = chatRoomService.getUserListInChatRoom(roomId);

		final ModelAndView mv = new ModelAndView("chat/usr.chat");
		mv.addObject("currentUser", user);
		mv.addObject("userList", userList);
		return mv;
	}
}
