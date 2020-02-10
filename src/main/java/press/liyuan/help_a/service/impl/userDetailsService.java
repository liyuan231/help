package press.liyuan.help_a.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import press.liyuan.help_a.dao.UserDao;
import press.liyuan.help_a.model.user;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userDetailsService implements UserDetailsService {
    @Resource(name ="userDao" )
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<user> users = userDao.selectUserByUsername(username);
        if(users.size()==0){
            return null;
        }
        user user=users.get(0);
        return User.withUsername(user.getUsername()).password(user.getPassword()).authorities("test").build();
    }
}
