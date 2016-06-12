package com.meinhell.myapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StompTestController {

	@RequestMapping("/websocket")
	public String websock(){
		return "websocket";
	}
	@MessageMapping("/stomp")
	@SendTo("/topic/stomp")
	public String sendEcho(String echoMessage){
		return echoMessage;
	}
	/*
	public ResponseEntity<String> stomp(String request)
	{
		return new ResponseEntity<String>(request, HttpStatus.OK);
	}
	*/
}
