package me.fincil.controller;

import me.fincil.model.user.User;
import me.fincil.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HSWook on 2016. 6. 7..
 */
@RestController
public class ApiController {

  @Autowired
  UserService userService;


  @RequestMapping("/users")
  public Iterable<User> allUser() {
    return userService.findAll();
  }

}
