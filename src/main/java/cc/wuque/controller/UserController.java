package cc.wuque.controller;

import cc.wuque.domain.User;
import cc.wuque.mapper.UserMapper;
import cc.wuque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

/**
 * @Author 无缺
 * @Date 2021/3/19 21:27
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "ok";
    }

    @RequestMapping("/findbyusername")
    public boolean findByUsername(@RequestParam("username") String username){
        boolean b = userService.findByUsername(username);
        return b;

    }

    @RequestMapping("/login")
    public String loginByUsernameAndPassword(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        User u = userService.loginByUsernameAndPassword(user);
        if (u != null){
            session.setAttribute("user",u);
            return "登录成功";
        }else {
            return "账号或密码错误";
        }

    }


}
