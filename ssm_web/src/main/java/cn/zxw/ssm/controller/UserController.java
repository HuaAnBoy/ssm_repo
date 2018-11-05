package cn.zxw.ssm.controller;

import cn.zxw.ssm.domain.UserInfo;
import cn.zxw.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 18:39
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("getUserName.do")
    public String getUserName() {

//        获得context对象
        SecurityContext context = SecurityContextHolder.getContext();

        String name = context.getAuthentication().getName();

        return name;
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
//        调用service
        List<UserInfo> list_uInfo = userService.findAll();

        mv.addObject("userList", list_uInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(UserInfo user) throws Exception {

        userService.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {

        ModelAndView mv = new ModelAndView();

        UserInfo userInfo = userService.findById(id);

        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {

        ModelAndView mv = new ModelAndView();

        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("role-list");
        return mv;
    }
}
