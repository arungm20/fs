package com.infosys.fs.dao.repository;

import com.infosys.fs.model.User;

public interface UserRepositoryCustom {


	User findByUserIdCustom(String userId);
}
