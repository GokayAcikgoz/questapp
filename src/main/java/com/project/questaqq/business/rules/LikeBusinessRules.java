package com.project.questaqq.business.rules;

import org.springframework.stereotype.Service;

import com.project.questaqq.core.utilities.exceptions.BusinessException;
import com.project.questaqq.dataAccess.abstracts.LikeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LikeBusinessRules {
	
	private LikeRepository likeRepository;
	
	public void checkIfLikeId(Long id) {
		if (!this.likeRepository.existsById(id)) {
			throw new BusinessException("Not like such");
		}
	}

}
