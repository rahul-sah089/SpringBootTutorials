package com.thymeleaf.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.thymeleaf.domain.User;
/*
 * At this point, our sample web application does nothing. But that’s about to change.

   Spring Data JPA allows us to implement JPA-based repositories (a fancy name for the DAO pattern implementation) 
   with minimal fuss.
   
   
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
	
}
