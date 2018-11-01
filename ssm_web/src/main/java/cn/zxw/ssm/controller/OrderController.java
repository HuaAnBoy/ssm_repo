package cn.zxw.ssm.controller;

import cn.zxw.ssm.domain.Order;
import cn.zxw.ssm.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 16:56
 */
@Controller
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*@RequestMapping("findAll.do")
   public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
//        调用service
        List<Order> orderList = orderService.findAll();
//        添加上集合
        mv.addObject("ordersList",orderList);
//        返回的视图
        mv.setViewName("orders-list");
        return mv;
    }*/


    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {

        ModelAndView mv = new ModelAndView();
//        调用service
        List<Order> orderList = orderService.findAll(page, size);
//        获得分页信息
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
//        添加上集合
        mv.addObject("orderPageInfo",orderPageInfo);
//        返回的视图
        mv.setViewName("orders-page-list");
        return mv;
    }
}
