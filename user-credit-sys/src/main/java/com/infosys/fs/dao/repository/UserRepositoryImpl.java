package com.infosys.fs.dao.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.infosys.fs.model.User;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User findByUserIdCustom(String userId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		List<User> users = mongoTemplate.find(query,User.class);
		
		LOGGER.info("Custom User :{}",users);
		
		return users.get(0);
	}
	
}
