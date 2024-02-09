package br.com.books.database.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.books.database.domain.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	UserDetails findByUserName(String userName);
}
