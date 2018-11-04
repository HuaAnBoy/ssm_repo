package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 15:25
 */
public interface UserDao {

    /**
     * 通过用户名查询users
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "cn.zxw.ssm.dao.RoleDao.findRoleByUid"))
    })
    UserInfo findByName(String username) throws Exception;

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 用户保存操作
     *
     * @param user
     * @throws Exception
     */
    @Insert("insert into users(email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;

    /**
     * 通过id查询用户详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "cn.zxw.ssm.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;
}
