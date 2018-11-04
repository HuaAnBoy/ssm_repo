package cn.zxw.ssm.dao;


import cn.zxw.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhangxiongwei
 * @data 2018/11/1
 * @time 20:57
 */
public interface MemberDao {

    /**
     * 通过id查询一个
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    Member findOneById(String id) throws Exception;
}
