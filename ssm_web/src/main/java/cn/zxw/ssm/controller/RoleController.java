package cn.zxw.ssm.controller;

import cn.zxw.ssm.domain.Role;
import cn.zxw.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/3
 * @time 21:27
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();

        List<Role> roleList = roleService.findAll();

        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Role role) throws Exception {

        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {

        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(id);

        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
}
