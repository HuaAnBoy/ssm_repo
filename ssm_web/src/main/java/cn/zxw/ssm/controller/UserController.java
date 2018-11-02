package cn.zxw.ssm.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 18:39
 */
@Controller
@RequestMapping("user")
public class UserController {

    @ResponseBody
    @RequestMapping("getUserName.do")
    public String getUserName(){
//        获得context对象
        SecurityContext context = SecurityContextHolder.getContext();

        String name = context.getAuthentication().getName();

        return name;
    }
}
