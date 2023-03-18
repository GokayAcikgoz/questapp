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

import com.project.questaqq.business.abstracts.PostService;
import com.project.questaqq.business.requests.CreatePostRequest;
import com.project.questaqq.business.requests.UpdatePostRequest;
import com.project.questaqq.business.responses.GetAllPostsResponse;
import com.project.questaqq.business.responses.GetByIdPostResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostsController {
	
	private PostService postService;
	
	//RequestParam bize gelen requestin parametrelerini parse et sağdaki değişkene at
		//Optional Parametre geledebilir gelmeyedebilir demek. Örneği notlarda
	@GetMapping()
	public List<GetAllPostsResponse> getAll(@RequestParam Optional<Long> userId){
		return postService.getAll(userId);
	}	
	
	@GetMapping("/{id}")
	public GetByIdPostResponse getById(@PathVariable Long id) {
		return postService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreatePostRequest createPostRequest) {
		this.postService.add(createPostRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdatePostRequest updatePostRequest) {
		this.postService.update(updatePostRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.postService.delete(id);
	}
}
