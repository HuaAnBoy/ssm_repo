package cn.zxw.ssm.controller;

import cn.zxw.ssm.domain.Product;
import cn.zxw.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 11:12
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
//        创建对象
        ModelAndView mv = new ModelAndView();
//        调用service
        List<Product> prod_list = productService.findAll();
//        写回
        mv.addObject("productList", prod_list);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product){
//        调用service
        productService.save(product);
//        返回关键字，重定向到findAll
        return "redirect:findAll.do";
    }
}
