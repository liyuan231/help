package press.liyuan.help_a.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import press.liyuan.help_a.dao.UserDao;
import press.liyuan.help_a.model.AccessToken;
import press.liyuan.help_a.model.GitHubUser;
import press.liyuan.help_a.service.impl.GitHubServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class OAuthController {
    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @Resource(name = "userDao")
    UserDao userDao;


    @Resource(name = "gitHubServiceImpl")
    GitHubServiceImpl gitHubService;
    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,
                           @RequestParam("state")String state,
                           HttpServletRequest request){
        String accessToken=gitHubService.getAccessToken(new AccessToken(client_id,client_secret,code,redirect_uri,state));
        GitHubUser gitHubUser=gitHubService.getGitHubUser(accessToken);
        if(gitHubUser!=null){
            userDao.insertGitHubUser(gitHubUser);
            request.getSession().setAttribute("user",gitHubUser);
        }else{

        }
        return "redirect:index";
        //使用okhttp进行post请求
    }
}
