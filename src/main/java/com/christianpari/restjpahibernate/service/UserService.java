package com.christianpari.restjpahibernate.service;

import com.christianpari.restjpahibernate.model.User;
import com.christianpari.restjpahibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserRepository database;

  // GET
  public User findById(Long id) { return database.findById(id).orElse(null); }

  public List<User> findAll() { return database.findAll(); }

  public Page<User> findAll(
    int page
    , int size
  ) {
    return database.findAll(PageRequest.of(page, size));
  }

  // POST --- PUT
  public User save(User user) { return database.save(user); }

  // DELETE
  public void remove(Long id) { database.deleteById(id); }
}
