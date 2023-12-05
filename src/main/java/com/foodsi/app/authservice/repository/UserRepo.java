package com.foodsi.app.authservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.foodsi.app.authservice.model.UserModel;

@Repository
public interface UserRepo extends MongoRepository<UserModel, String>  {
	
	UserModel findByUserName(String userName);
}
