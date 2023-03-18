package com.project.questaqq.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questaqq.business.abstracts.LikeService;
import com.project.questaqq.business.requests.CreateLikeRequest;
import com.project.questaqq.business.responses.GetAllLikesResponse;
import com.project.questaqq.business.responses.GetByIdLikeResponse;
import com.project.questaqq.business.rules.PostBusinessRules;
import com.project.questaqq.business.rules.UserBusinessRules;
import com.project.questaqq.core.utilities.mappers.ModelMapperService;
import com.project.questaqq.dataAccess.abstracts.LikeRepository;
import com.project.questaqq.entities.concrete.Like;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService{
	
	private LikeRepository likeRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	private PostBusinessRules postBusinessRules;
	//private LikeBusinessRules likeBusinessRules;
	
	@Override
	public List<GetAllLikesResponse> getAll(Optional<Long> userId, Optional<Long> postId) {
		
		//List<Like> likes = likeRepository.findAll();
		
		List<Like> likes = userId.flatMap(u -> postId.map(p -> likeRepository.findByUserIdAndPostId(u, p)))
	            .orElseGet(() -> userId.map(likeRepository::findByUserId).orElseGet(() ->
                postId.map(likeRepository::findByPostId).orElseGet(likeRepository::findAll)));
		
		List<GetAllLikesResponse> likesResponses = likes.stream().map(like -> this.modelMapperService.forResponse()
				.map(like, GetAllLikesResponse.class)).collect(Collectors.toList());
		
		return likesResponses;
	}

	@Override
	public GetByIdLikeResponse getById(Long id) {
		
		Like like = this.likeRepository.findById(id).orElseThrow();
		
		GetByIdLikeResponse response = this.modelMapperService.forResponse().map(like, GetByIdLikeResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateLikeRequest createLikeRequest) {
		
		this.userBusinessRules.checkIfUserExists(createLikeRequest.getUserId());
		this.postBusinessRules.chechkIfPostId(createLikeRequest.getPostId());
		
		Like like = this.modelMapperService.forRequest().map(createLikeRequest, Like.class);
		
		this.likeRepository.save(like);
		
	}

	/*
	 * @Override public void update(UpdateLikeRequest updateLikeRequest) {
	 * 
	 * this.likeBusinessRules.checkIfLikeId(updateLikeRequest.getId());
	 * 
	 * Like like = this.modelMapperService.forRequest().map(updateLikeRequest,
	 * Like.class);
	 * 
	 * }
	 */

	@Override
	public void delete(Long id) {
		
		this.likeRepository.deleteById(id);
		
	}

	
}
