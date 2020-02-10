package press.liyuan.help_a.service.impl;

import org.springframework.stereotype.Service;
import press.liyuan.help_a.dao.UserDao;
import press.liyuan.help_a.model.user;
import press.liyuan.help_a.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    UserDao userDao;

    public void insertUser(user user){
        userDao.insertUser(user.getUsername(),user.getPassword());
    }
}
