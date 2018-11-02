package cn.zxw.ssm.service.impl;

import cn.zxw.ssm.dao.UserDao;
import cn.zxw.ssm.domain.Role;
import cn.zxw.ssm.domain.UserInfo;
import cn.zxw.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 14:57
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        获得roles集合
        List<Role> roles = userInfo.getRoles();
//        调用本类方法
        List<SimpleGrantedAuthority> authority = getAuthority(roles);

        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true, true, authority);
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return authorityList;
    }
}
