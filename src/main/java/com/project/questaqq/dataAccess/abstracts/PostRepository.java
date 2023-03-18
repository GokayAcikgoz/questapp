package com.project.questaqq.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questaqq.entities.concrete.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByUserId(Long userId);
	
	boolean existsById(Long id);
}
