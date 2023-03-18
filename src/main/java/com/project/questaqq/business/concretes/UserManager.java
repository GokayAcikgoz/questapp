package com.project.questaqq.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questaqq.business.abstracts.UserService;
import com.project.questaqq.business.requests.CreateUserRequest;
import com.project.questaqq.business.requests.UpdateUserRequest;
import com.project.questaqq.business.responses.GetAllUsersResponse;
import com.project.questaqq.business.responses.GetByIdUserResponse;
import com.project.questaqq.business.rules.UserBusinessRules;
import com.project.questaqq.core.utilities.mappers.ModelMapperService;
import com.project.questaqq.dataAccess.abstracts.UserRepository;
import com.project.questaqq.entities.concrete.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	
	@Override
	public List<GetAllUsersResponse> getAll() {
		
		List<User> users = userRepository.findAll();
		
		List<GetAllUsersResponse> userResponse = users.stream().map(user -> this.modelMapperService.forResponse()
				.map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
		
		return userResponse;
	}

	@Override
	public GetByIdUserResponse getById(Long id) {
		
		User user = userRepository.findById(id).orElseThrow();
		
		GetByIdUserResponse response = this.modelMapperService.forResponse()
				.map(user, GetByIdUserResponse.class);
		
		return response;
	}

	
	@Override 
	public void add(CreateUserRequest createUserRequest) {
	  
	//business Rules
	this.userBusinessRules.checkIfUserNameExists(createUserRequest.getUserName());
	  
	User user = this.modelMapperService.forRequest().map(createUserRequest,
	User.class);
	  
	this.userRepository.save(user);
	  
    }
	 
	 
	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		
		this.userRepository.save(user);
		
	}

	@Override
	public void delete(Long id) {
		
		this.userRepository.deleteById(id);
		
	}

	@Override
	public User getOneUserByUserName(String userName) {

		return this.userRepository.findByUserName(userName);
	}

	@Override
	public User saveOneUser(User user) {
		
		return this.userRepository.save(user);
	}
	
	
}
