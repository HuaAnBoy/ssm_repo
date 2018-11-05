package cn.zxw.ssm.service.impl;

import cn.zxw.ssm.dao.RoleDao;
import cn.zxw.ssm.domain.Role;
import cn.zxw.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/3
 * @time 21:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {

        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {

        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {

        Role ro = roleDao.findById(id);
        System.out.println(ro);
        return ro;
    }
}
