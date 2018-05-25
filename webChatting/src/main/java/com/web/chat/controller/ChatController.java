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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
		final ModelAndView mav = new ModelAndView("home");
		
		mav.addObject("roomList", chatRoomService.getCurrentChatRoomList());
		return mav;
	}

	@PostMapping("/room")
	public ModelAndView makeChatRoom(
			@RequestParam("title") String title,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType,
			SessionStatus status) {

		final ChatRoom room = chatRoomService.makeChatRoom(title);
		final UserHistory user = chatRoomService.joinChatRoom(nickName, avatarType, room.getRoomId());
		final List<UserHistory> userList = chatRoomService.getUserListInChatRoom(room.getRoomId());
		
		final ModelAndView mav = new ModelAndView("chat/usr.chat");
		mav.addObject("room", room);
		mav.addObject("currentUser", user);
		mav.addObject("userList", userList);
		
		status.isComplete();
		return mav;
	}
	
	@PostMapping("/room/{roomId}")
	public ModelAndView joinChatRoom(
			@PathVariable Long roomId,
			@RequestParam("nickName") String nickName, 
			@RequestParam("avatar") int avatarType,
			SessionStatus status) {

		final ChatRoom room = chatRoomService.getCurrentChatRoom(roomId);
		final UserHistory user = chatRoomService.joinChatRoom(nickName, avatarType, roomId);
		final List<UserHistory> userList = chatRoomService.getUserListInChatRoom(roomId);

		final ModelAndView mav = new ModelAndView("chat/usr.chat");
		mav.addObject("room", room);
		mav.addObject("currentUser", user);
		mav.addObject("userList", userList);
		
		status.isComplete();
		return mav;
	}
}
