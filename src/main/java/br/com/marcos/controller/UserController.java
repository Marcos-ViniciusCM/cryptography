package br.com.marcos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.dto.CreateUserRequest;
import br.com.marcos.dto.UserResponse;
import br.com.marcos.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CreateUserRequest request){
		service.create(request);
		
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> listAll(){
		List<UserResponse> content = service.findAll();
		if(content.size() > 0) {
			return new ResponseEntity<List<UserResponse>>(content,HttpStatus.OK);
		}else
			return new ResponseEntity<List<UserResponse>>(HttpStatus.NOT_FOUND);

		
		
		
	}
}
