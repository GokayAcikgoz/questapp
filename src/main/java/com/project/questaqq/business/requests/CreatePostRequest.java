package com.project.questaqq.business.requests;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
	
	@NotNull
	private Long userId;
	private String title;
	private String text;
}
