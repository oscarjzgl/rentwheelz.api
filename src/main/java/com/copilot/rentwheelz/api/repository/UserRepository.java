package com.copilot.rentwheelz.api.repository;

import com.copilot.rentwheelz.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserEmail(String userEmail);
    User findByUserNameAndUserPassword(String userName, String userPassword);
}