package cn.zxw.ssm.service;

import cn.zxw.ssm.domain.Product;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 11:06
 */
public interface ProductService {

    /**
     * 查找所有
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 保存方法
     * @param product
     */
    void save(Product product);
}
