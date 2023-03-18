package com.project.questaqq.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questaqq.business.abstracts.PostService;
import com.project.questaqq.business.requests.CreatePostRequest;
import com.project.questaqq.business.requests.UpdatePostRequest;
import com.project.questaqq.business.responses.GetAllPostsResponse;
import com.project.questaqq.business.responses.GetByIdPostResponse;
import com.project.questaqq.business.rules.PostBusinessRules;
import com.project.questaqq.business.rules.UserBusinessRules;
import com.project.questaqq.core.utilities.mappers.ModelMapperService;
import com.project.questaqq.dataAccess.abstracts.PostRepository;
import com.project.questaqq.entities.concrete.Post;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostManager implements PostService{
	
	private PostRepository postRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	private PostBusinessRules postBusinessRules;
	
	@Override
	public List<GetAllPostsResponse> getAll(Optional<Long> userId) {
		
		/*
			List<Post> posts = postRepository.findByUserId(userId.get());
			*/
			List<Post> posts = userId.map(postRepository::findByUserId).orElse(postRepository.findAll());
		
			List<GetAllPostsResponse> postsResponse = posts.stream().map(post -> this.modelMapperService.forResponse()
					.map(post, GetAllPostsResponse.class)).collect(Collectors.toList());
			
			
			return postsResponse;
				
		
	}

	@Override
	public GetByIdPostResponse getById(Long id) {
		
		Post post = this.postRepository.findById(id).orElseThrow();
		
		GetByIdPostResponse response = this.modelMapperService.forResponse().map(post, GetByIdPostResponse.class);
		
		return response;
	}

	@Override
	public void add(CreatePostRequest createPostRequest) {
		
		this.userBusinessRules.checkIfUserExists(createPostRequest.getUserId());
		
		
		Post post = this.modelMapperService.forRequest().map(createPostRequest, Post.class);
		
		this.postRepository.save(post);
		
		
	}

	@Override
	public void update(UpdatePostRequest updatePostRequest) {
		
		this.postBusinessRules.chechkIfPostId(updatePostRequest.getId());
		
		Post post = this.modelMapperService.forRequest().map(updatePostRequest, Post.class);
		
		this.postRepository.save(post);
		
	}

	@Override
	public void delete(Long id) {
		
		this.postRepository.deleteById(id);
		
	}

	
}
