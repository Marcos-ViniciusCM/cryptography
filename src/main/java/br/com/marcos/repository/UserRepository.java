package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
