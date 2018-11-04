package cn.zxw.ssm.service;

import cn.zxw.ssm.domain.Permission;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/4
 * @time 16:36
 */
public interface PermissionService  {

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 保存用户
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;
}
