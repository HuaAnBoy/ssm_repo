package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 16:12
 */
public interface RoleDao {

    /**
     * 关联查询
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{uid})")
    List<Role> findRoleByUid(String uid) throws Exception;

    /**
     * 查找所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 保存用户
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 通过uid查询出role的详情
     *
     * @param uid
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{uid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "cn.zxw.ssm.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findRoleByUserId(String uid) throws Exception;

    /**
     * id查询一个
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "cn.zxw.ssm.dao.PermissionDao.findPermissionsByRid"))
    })
    Role findById(String id);
}
