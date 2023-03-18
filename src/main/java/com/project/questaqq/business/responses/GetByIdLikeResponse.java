package com.project.questaqq.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLikeResponse {

	private Long id;
	private Long userId;
	private Long postId;
}
