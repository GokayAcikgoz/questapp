package com.project.questaqq.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.project.questaqq.business.requests.CreateCommentRequest;
import com.project.questaqq.business.requests.UpdateCommentRequest;
import com.project.questaqq.business.responses.GetAllCommentsResponse;
import com.project.questaqq.business.responses.GetByIdCommentResponse;

public interface CommentService {
	
	List<GetAllCommentsResponse> getAll(Optional<Long> userId, Optional<Long> postId);
	GetByIdCommentResponse getById(Long id);
	void add(CreateCommentRequest createCommentRequest);
	void update(UpdateCommentRequest updateCommentRequest);
	void delete(Long id);
	
}
