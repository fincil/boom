package me.fincil.controller;

import me.fincil.model.user.User;
import me.fincil.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HSWook on 2016. 6. 7..
 */
@RestController
public class ApiController {

  @Autowired
  CommonService<User> userCommonService;

  @RequestMapping("/users")
  public Iterable<User> allUser() {
    return userCommonService.findAll();
  }

}
