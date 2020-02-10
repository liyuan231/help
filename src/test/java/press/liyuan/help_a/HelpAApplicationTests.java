package press.liyuan.help_a;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import press.liyuan.help_a.model.user;
import press.liyuan.help_a.service.UserService;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelpAApplicationTests {

    @Resource(name = "userServiceImpl")
    UserService userService;
    @Resource(name = "bCryptPasswordEncoder")
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        userService.insertUser(new user(null,"liyuan",bCryptPasswordEncoder.encode("123456")));
    }

}
