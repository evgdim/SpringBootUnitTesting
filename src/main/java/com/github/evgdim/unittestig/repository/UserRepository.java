package com.github.evgdim.unittestig.repository;

import java.util.List;

import com.github.evgdim.unittestig.domain.User;

public interface UserRepository {
	public List<User> findAllUsers();
}
