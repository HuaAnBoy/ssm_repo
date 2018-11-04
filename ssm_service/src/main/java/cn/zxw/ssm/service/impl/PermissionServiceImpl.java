package cn.zxw.ssm.service.impl;

import cn.zxw.ssm.dao.PermissionDao;
import cn.zxw.ssm.domain.Permission;
import cn.zxw.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/4
 * @time 16:36
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {

        permissionDao.save(permission);
    }
}
