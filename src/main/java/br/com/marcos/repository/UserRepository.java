package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
