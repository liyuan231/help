package press.liyuan.help_a.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import press.liyuan.help_a.model.GitHubUser;
import press.liyuan.help_a.model.user;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Insert("insert into user(username,password)values(#{username},#{password})")
    public void insertUser(@Param("username") String username,
                           @Param("password") String password);
    @Insert("insert into gitHubUser(id,avatar_url,name,bio,created_at,updated_at)values(#{id},#{avatar_url},#{name},#{bio},#{created_at},#{updated_at})")
    public void insertGitHubUser(GitHubUser gitHubUser);

    @Select("select * from user where username = #{username}")
    public List<user> selectUserByUsername(@Param("username") String username);


}
