package com.project.questaqq.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {
	
	private Long id;
	//private Long userId;
	private String title;
	private String text;
}
