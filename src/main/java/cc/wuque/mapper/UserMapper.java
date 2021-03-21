package cc.wuque.mapper;

import cc.wuque.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:26
 */
@Mapper
public interface UserMapper {

    List<User> queryUserList();

    String findByUsername(String username);

    void register(User user);

    User loginByUsernameAndPassword(User user);


}
