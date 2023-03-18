package com.project.questaqq.business.abstracts;

import java.util.List;

import com.project.questaqq.business.requests.CreateUserRequest;
import com.project.questaqq.business.requests.UpdateUserRequest;
import com.project.questaqq.business.responses.GetAllUsersResponse;
import com.project.questaqq.business.responses.GetByIdUserResponse;
import com.project.questaqq.entities.concrete.User;

public interface UserService {
	
	List<GetAllUsersResponse> getAll();
	GetByIdUserResponse getById(Long id);
	void add(CreateUserRequest createUserRequest);
	void update(UpdateUserRequest updateUserRequest);
	void delete(Long id);
	User getOneUserByUserName(String userName);
	User saveOneUser(User user);
}
