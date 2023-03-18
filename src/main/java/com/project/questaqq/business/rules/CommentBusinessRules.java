package com.project.questaqq.business.rules;

import org.springframework.stereotype.Service;

import com.project.questaqq.core.utilities.exceptions.BusinessException;
import com.project.questaqq.dataAccess.abstracts.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentBusinessRules {
	
	private CommentRepository commentRepository;
	
	public void checkIfCommentId(Long id) {
		if (!this.commentRepository.existsById(id)) {
			throw new BusinessException("Not comment such");
		}
	}

}
