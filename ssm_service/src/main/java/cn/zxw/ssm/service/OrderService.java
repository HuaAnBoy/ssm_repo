package cn.zxw.ssm.service;

import cn.zxw.ssm.domain.Order;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 17:06
 */
public interface OrderService {

    /**
     * 查找所有
     * @return
     * @throws Exception
     */
    List<Order> findAll() throws Exception;

    /**
     * 分页查找
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Order> findAll(int page,int size) throws Exception;
}
