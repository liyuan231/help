package press.liyuan.help_a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {
    private Integer userId;
    private String username;
    private String password;
}
