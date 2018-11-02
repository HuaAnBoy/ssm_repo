package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 16:12
 */
public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{uid})")
    List<Role> findRoleByUid(String uid);
}
