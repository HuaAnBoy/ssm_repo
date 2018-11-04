package cn.zxw.ssm.service;

import cn.zxw.ssm.domain.Role;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/3
 * @time 21:24
 */
public interface RoleService {

    /**
     * 茶渣所有
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 保存用户
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;

    /**
     * 通过id查询一个
     * @param id
     * @return
     * @throws Exception
     */
    Role findById(String id) throws Exception;
}
