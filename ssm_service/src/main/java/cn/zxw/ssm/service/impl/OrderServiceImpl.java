package cn.zxw.ssm.service.impl;


import cn.zxw.ssm.dao.OrderDao;
import cn.zxw.ssm.domain.Order;
import cn.zxw.ssm.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 16:55
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll() throws Exception {

        return orderDao.findAll();
    }

    @Override
    public List<Order> findAll(int page, int size) throws Exception {

//        调用分页插件
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }
}
