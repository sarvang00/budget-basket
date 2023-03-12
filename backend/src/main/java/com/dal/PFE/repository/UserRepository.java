package com.dal.PFE.repository;

import com.dal.PFE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("from User as u where u.email=?1 and u.password=?2")
    User findUserByEmailPassword(String email, String password);

}
