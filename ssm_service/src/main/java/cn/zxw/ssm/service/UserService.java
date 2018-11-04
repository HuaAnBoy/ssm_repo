package cn.zxw.ssm.service;

import cn.zxw.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author zhangxiongwei
 * @data 2018/11/2
 * @time 14:56
 */
public interface UserService extends UserDetailsService {

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    void save(UserInfo user) throws Exception;

    /**
     * 同过id查询user详情
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findById(String id) throws Exception;
}
