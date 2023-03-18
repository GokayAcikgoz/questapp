package com.project.questaqq.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.project.questaqq.business.requests.CreateLikeRequest;
import com.project.questaqq.business.responses.GetAllLikesResponse;
import com.project.questaqq.business.responses.GetByIdLikeResponse;

public interface LikeService {
	
	List<GetAllLikesResponse> getAll(Optional<Long> userId, Optional<Long> postId);
	GetByIdLikeResponse getById(Long id);
	void add(CreateLikeRequest createLikeRequest);
	//void update(UpdateLikeRequest updateLikeRequest);
	void delete(Long id);
	
}
