package br.com.marcos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.marcos.dto.CreateUserRequest;
import br.com.marcos.dto.UserResponse;
import br.com.marcos.dto.UserUpdateValue;
import br.com.marcos.model.User;
import br.com.marcos.repository.UserRepository;
@Service
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
	
	public User findById(Long id) {
		return  repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	public User updateUser(Long id, UserUpdateValue userdto) {
		var entity = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		entity.setValue(userdto.value());
		return repository.save(entity);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	
	

}
