package cn.zxw.ssm.controller;

import cn.zxw.ssm.domain.Permission;
import cn.zxw.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/4
 * @time 16:34
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();

        List<Permission> permissions = permissionService.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Permission permission) throws Exception {

        permissionService.save(permission);

        return "redirect:findAll.do";
    }
}
