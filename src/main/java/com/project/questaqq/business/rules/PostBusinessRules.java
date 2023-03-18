package com.project.questaqq.business.rules;

import org.springframework.stereotype.Service;

import com.project.questaqq.core.utilities.exceptions.BusinessException;
import com.project.questaqq.dataAccess.abstracts.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostBusinessRules {
	
	private PostRepository postRepository;
	
	public void chechkIfPostId(Long id) {
		if (!this.postRepository.existsById(id)) {
			throw new BusinessException("Not post such");
		}
	}

}
