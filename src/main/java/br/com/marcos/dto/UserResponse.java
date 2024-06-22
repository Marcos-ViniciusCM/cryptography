package br.com.marcos.dto;

import br.com.marcos.model.User;

public record UserResponse(Long id,String userDocument,String creditCardToken,Long value) {

	
	
	public static UserResponse fromEntity(User entity) {
		return new UserResponse(
				entity.getId(),
				entity.getRawuserDocument(),
				entity.getRawcreditCardToken(),
				entity.getValue()
				);
	}
}
