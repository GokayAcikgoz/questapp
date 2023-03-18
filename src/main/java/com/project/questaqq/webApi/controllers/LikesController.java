package com.project.questaqq.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.questaqq.business.abstracts.LikeService;
import com.project.questaqq.business.requests.CreateLikeRequest;
import com.project.questaqq.business.responses.GetAllLikesResponse;
import com.project.questaqq.business.responses.GetByIdLikeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/like")
@AllArgsConstructor
public class LikesController {
	
	private LikeService likeService;
	
	@GetMapping
	public List<GetAllLikesResponse> getAll(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
		return likeService.getAll(userId, userId);
	}
	
	@GetMapping("/{id}")
	public GetByIdLikeResponse getById(@PathVariable Long id) {
		return likeService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateLikeRequest createLikeRequest) {
		this.likeService.add(createLikeRequest);
	}
	
	/*
	 * @PutMapping public void update(@RequestBody UpdateLikeRequest
	 * updateLikeRequest) { this.likeService.update(updateLikeRequest); }
	 */
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.likeService.delete(id);
	}
	

}
