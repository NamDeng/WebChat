package com.web.chat.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.web.chat.service.ChatRoomService;

/**
 * Handles requests for the application home page.
 */

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@Resource(name="chatRoomService")
	ChatRoomService chatRoomService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		return mv;
	}

	@PostMapping("/room")
	public ModelAndView makeChatRoom(
			@RequestParam("nickName") String nickName, 
			@RequestParam("title") String title,
			@RequestParam("avatar") String avatar) {

		final ModelAndView mv = new ModelAndView("chat/usr.chat");
		chatRoomService.makeChatRoom(title, nickName);
		return mv;
	}
}
