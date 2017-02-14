package br.com.igorshiohara.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRS {
	
	@RequestMapping(path = "/")
	public String login() {
		return "index";
	}
	
	@RequestMapping(path = "/v1/admin/access" , method = RequestMethod.GET)
	public ResponseEntity<String> getAdminMessage() {
		return ResponseEntity.ok("Hello Admin");
	}
	
	@RequestMapping(path = "/v1/user/message" , method = RequestMethod.GET)
	public ResponseEntity<String> getUserMessage() {
		return ResponseEntity.ok("Hello User!");
	}

}
