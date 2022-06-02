package com.ssg.shoppingcart.repository.user;

import com.ssg.shoppingcart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(@Param("") String email);
}
