package cc.wuque.service.impl;

import cc.wuque.domain.User;
import cc.wuque.mapper.UserMapper;
import cc.wuque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:34
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean findByUsername(String username) {
        boolean result = false;
        String s = userMapper.findByUsername(username);
        System.out.println(s);
        if (userMapper.findByUsername(username) == null){

            result = true;
        }

        return result;
    }



    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User loginByUsernameAndPassword(User user) {
        return userMapper.loginByUsernameAndPassword(user);

    }
}
