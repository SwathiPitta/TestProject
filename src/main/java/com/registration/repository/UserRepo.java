package com.registration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.registration.beans.UserDetails;

public interface UserRepo extends CrudRepository<UserDetails, Long>{
	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM UserDetails r WHERE r.emailId=:emailId")
	boolean existsByEmailId(@Param("emailId") String emailId);

}
