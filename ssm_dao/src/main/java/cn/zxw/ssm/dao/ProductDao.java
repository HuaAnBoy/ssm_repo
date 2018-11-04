package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 10:46
 */
public interface ProductDao {

    /**
     * 查找所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 保存商品信息
     *
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 通过id查找一个
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    Product findOneById(String id) throws Exception;
}
