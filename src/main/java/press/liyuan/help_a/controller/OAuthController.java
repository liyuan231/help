package press.liyuan.help_a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import press.liyuan.help_a.model.AccessToken;
import press.liyuan.help_a.model.GitHubUser;
import press.liyuan.help_a.service.impl.GitHubServiceImpl;

import javax.annotation.Resource;

@Controller
public class OAuthController {
    @Resource(name = "gitHubServiceImpl")
    GitHubServiceImpl gitHubService;
    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,
                           @RequestParam("state")String state){
        String accessToken=gitHubService.getAccessToken(new AccessToken("c64b4a90108f6a0b3e8e","63f66230dda3c5e0920c5c83581b8001496046cd",code,"http://localhost/callback",state));
        GitHubUser gitHubUser=gitHubService.getGitHubUser(accessToken);
        System.out.println(gitHubUser);

        //使用okhttp进行post请求
        return "index";
    }
}
