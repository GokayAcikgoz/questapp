package com.project.questaqq.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPostsResponse {

	private Long id;
	private Long userId;
	private String userName;
	private String title;
	private String text;
	private List<GetAllLikesResponse> postLikes;
}
