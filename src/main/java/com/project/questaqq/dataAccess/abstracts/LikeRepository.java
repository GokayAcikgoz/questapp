package com.project.questaqq.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questaqq.entities.concrete.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	boolean existsById(Long id);
	
	List<Like> findByUserId(Long userId);
	
	List<Like> findByPostId(Long postId);

	List<Like> findByUserIdAndPostId(Long userId, Long postId);
}
