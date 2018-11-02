package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Member;
import cn.zxw.ssm.domain.Order;
import cn.zxw.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 16:54
 */
public interface OrderDao {

    /**
     * 查找所有
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "cn.zxw.ssm.dao.ProductDao.findOneById"))
    })
    List<Order> findAll() throws Exception;

    /**
     * 通过id查询一个
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "cn.zxw.ssm.dao.ProductDao.findOneById")),
            @Result(property = "travellers",column = "id",javaType = List.class,
                    many = @Many(select = "cn.zxw.ssm.dao.TravellerDao.findByOrderId")),
            @Result(property = "member",column = "memberid",javaType = Member.class,
                    one = @One(select = "cn.zxw.ssm.dao.MemberDao.findOneById"))
    })
    Order findById(String id) throws Exception;
}
