package com.project.questaqq.business.rules;

import org.springframework.stereotype.Service;

import com.project.questaqq.core.utilities.exceptions.BusinessException;
import com.project.questaqq.dataAccess.abstracts.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service //new lemeden kullanacaz. enject ederek kullanım. IOC yerleşsin diye service
public class UserBusinessRules {
	
	private UserRepository userRepository;
	
	//User Repositorye kendimiz tanımladık. JPA NIN GÜZELLEİGİ
	public void checkIfUserNameExists(String userName) {
		if (this.userRepository.existsByUserName(userName)) { 
			throw new BusinessException("User already exists"); //core altına businessexception oluşturacağız
		}
	}
	
	public void checkIfUserExists(Long id) {
		if (!this.userRepository.existsById(id)) {
			throw new BusinessException("Not user such");
		}
	}

}
