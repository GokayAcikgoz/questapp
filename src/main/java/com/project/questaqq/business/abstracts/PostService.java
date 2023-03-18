package com.project.questaqq.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.project.questaqq.business.requests.CreatePostRequest;
import com.project.questaqq.business.requests.UpdatePostRequest;
import com.project.questaqq.business.responses.GetAllPostsResponse;
import com.project.questaqq.business.responses.GetByIdPostResponse;

public interface PostService {
	
	List<GetAllPostsResponse> getAll(Optional<Long> userId);
	GetByIdPostResponse getById(Long id);
	void add(CreatePostRequest createPostRequest);
	void update(UpdatePostRequest updatePostRequest);
	void delete(Long id);
	
}
