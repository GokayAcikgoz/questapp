package com.project.questaqq.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.questaqq.business.abstracts.CommentService;
import com.project.questaqq.business.requests.CreateCommentRequest;
import com.project.questaqq.business.requests.UpdateCommentRequest;
import com.project.questaqq.business.responses.GetAllCommentsResponse;
import com.project.questaqq.business.responses.GetByIdCommentResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
public class CommentsController {
	
	private CommentService commentService;
	
	@GetMapping
	public List<GetAllCommentsResponse> getAll(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
		return commentService.getAll(userId, postId);
	}
	
	@GetMapping("/{id}")
	public GetByIdCommentResponse getById(@PathVariable Long id) {
		return commentService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateCommentRequest createCommentRequest) {
		this.commentService.add(createCommentRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateCommentRequest updateCommentRequest) {
		this.commentService.update(updateCommentRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.commentService.delete(id);
	}

}
