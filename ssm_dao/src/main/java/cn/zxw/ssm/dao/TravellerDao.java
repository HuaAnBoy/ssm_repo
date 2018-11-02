package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 20:57
 */
public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findByOrderId(String ordersId) throws Exception;
}
