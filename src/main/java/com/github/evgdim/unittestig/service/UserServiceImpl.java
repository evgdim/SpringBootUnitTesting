package com.github.evgdim.unittestig.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.evgdim.unittestig.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAllUsers() {
		return Arrays.asList(
				new User(1L,"first",(short)15),
				new User(2L,"second",(short)17),
				new User(3L,"third",(short)100)
		);
	}

}
