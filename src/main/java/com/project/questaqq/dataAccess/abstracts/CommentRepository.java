package com.project.questaqq.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questaqq.entities.concrete.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	boolean existsById(Long id);
	
	List<Comment> findByUserId(Long userId);
	
	List<Comment> findByPostId(Long postId);

	List<Comment> findByUserIdAndPostId(Long userId, Long postId);
}
