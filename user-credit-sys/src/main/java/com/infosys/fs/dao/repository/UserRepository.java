package com.infosys.fs.dao.repository;

import org.springframework.stereotype.Repository;

import com.infosys.fs.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUserId(String userId);
	
}
