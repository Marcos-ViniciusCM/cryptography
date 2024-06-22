package br.com.marcos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.marcos.dto.CreateUserRequest;
import br.com.marcos.dto.UserResponse;
import br.com.marcos.model.User;
import br.com.marcos.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<UserResponse> findAll() {
		List<User> content = repository.findAll();
	    return content.stream()
	                  .map(UserResponse::fromEntity)
	                  .collect(Collectors.toList());
		}
	
	
	public void create(CreateUserRequest request) {
		var entity = new User();
		entity.setRawcreditCardToken(request.creditCardToken());
		entity.setRawuserDocument(request.userDocument());
		entity.setValue(request.value());
		
		repository.save(entity);
	}
	
	
	

}
