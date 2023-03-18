package com.project.questaqq.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLikeRequest {

	private Long id;
	private Long userId;
	private Long postId;
}
