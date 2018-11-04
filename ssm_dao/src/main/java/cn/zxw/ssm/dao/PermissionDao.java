package cn.zxw.ssm.dao;

import cn.zxw.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/4
 * @time 12:47
 */
public interface PermissionDao {

    /**
     * 通过rid查询出permission对象
     * @param rid
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{rid})")
    Permission findPermissionByRoleId(String rid) throws Exception;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @Select("select * from permission ")
    List<Permission> findAll() throws Exception;

    /**
     * 保存permission
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
