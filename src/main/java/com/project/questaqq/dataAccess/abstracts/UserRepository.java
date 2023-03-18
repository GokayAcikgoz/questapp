package com.project.questaqq.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questaqq.entities.concrete.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByUserName(String name); //JPA kendi sorgu oluşturur. spring jpa keywords
	
	boolean existsById(Long id);  // exist ile bir nesnenin var olup olmadığını kontrol ederiz.
	
	User findByUserName(String userName);
	
}
