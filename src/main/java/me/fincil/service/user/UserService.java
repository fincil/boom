package me.fincil.service.user;

import me.fincil.model.user.User;
import me.fincil.service.ModelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by HSWook on 2016. 6. 12..
 */
@Service
@Transactional
public class UserService extends ModelService<User> {
}
