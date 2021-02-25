package com.christianpari.restjpahibernate.controller;

import com.christianpari.restjpahibernate.model.User;
import com.christianpari.restjpahibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  UserService service;

  @GetMapping("/allUsers")
  public Object getUserPage(
    @RequestParam(required = false, defaultValue = "0") Integer page
    , @RequestParam(required = false, defaultValue = "30") Integer size
  ) {

    // using pagination allows us to only get a certain amount of documents from a DB, this way we don't overload a request/response
    Page<User> getPage = service.findAll(page, size);

    Map<String, Object> map = new HashMap<>();
    map.put("content", getPage.getContent());
    map.put("page", page);
    map.put("size", size);
    map.put("totalPages", getPage.getTotalPages());
    map.put("totalItems", getPage.getTotalElements());

    return map;
  }

  @PostMapping("/newUser")
  public Object postUser(
    @RequestBody User user
  ) {
    return service.save(user).strip();
  }
}
