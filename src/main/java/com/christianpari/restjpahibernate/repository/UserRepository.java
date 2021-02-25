package com.christianpari.restjpahibernate.repository;

import com.christianpari.restjpahibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
