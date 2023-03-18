package com.project.questaqq.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questaqq.business.abstracts.CommentService;
import com.project.questaqq.business.requests.CreateCommentRequest;
import com.project.questaqq.business.requests.UpdateCommentRequest;
import com.project.questaqq.business.responses.GetAllCommentsResponse;
import com.project.questaqq.business.responses.GetByIdCommentResponse;
import com.project.questaqq.business.rules.CommentBusinessRules;
import com.project.questaqq.business.rules.PostBusinessRules;
import com.project.questaqq.business.rules.UserBusinessRules;
import com.project.questaqq.core.utilities.mappers.ModelMapperService;
import com.project.questaqq.dataAccess.abstracts.CommentRepository;
import com.project.questaqq.entities.concrete.Comment;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService{
	
	private CommentRepository commentRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	private PostBusinessRules postBusinessRules;
	private CommentBusinessRules commentBusinessRules;
	
	@Override
	public List<GetAllCommentsResponse> getAll(Optional<Long> userId, Optional<Long> postId) {
		
		//FlatMap değişkenlerden birisi boş ise çalışmayacktır. O yüzden postId kontrol için map açtık. 
		//userId yi zaten ilk olarak kontrol eden bir yapısı var.
		List<Comment> comments = userId.flatMap(u -> postId.map(p -> commentRepository.findByUserIdAndPostId(u, p)))
	            .orElseGet(() -> userId.map(commentRepository::findByUserId).orElseGet(() ->
	                    postId.map(commentRepository::findByPostId).orElseGet(commentRepository::findAll)));
		
		List<GetAllCommentsResponse> commentsResponses = 
				comments.stream().map(comment -> this.modelMapperService.forResponse()
						.map(comment, GetAllCommentsResponse.class)).collect(Collectors.toList());
		
		return commentsResponses;
				
	}

	@Override
	public GetByIdCommentResponse getById(Long id) {
		
		Comment comment = this.commentRepository.findById(id).orElseThrow();
		
		GetByIdCommentResponse response = this.modelMapperService.forResponse()
				.map(comment, GetByIdCommentResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateCommentRequest createCommentRequest) {
		
		this.userBusinessRules.checkIfUserExists(createCommentRequest.getUserId());
		this.postBusinessRules.chechkIfPostId(createCommentRequest.getPostId());
		
		Comment comment = this.modelMapperService.forRequest().map(createCommentRequest, Comment.class);
		
		this.commentRepository.save(comment);
		
	}

	@Override
	public void update(UpdateCommentRequest updateCommentRequest) {
		
		this.commentBusinessRules.checkIfCommentId(updateCommentRequest.getId());
		
		Comment comment = this.modelMapperService.forRequest().map(updateCommentRequest, Comment.class);
		
		this.commentRepository.save(comment);
		
	}

	@Override
	public void delete(Long id) {
		
		this.commentRepository.deleteById(id);
		
	}

	

}
