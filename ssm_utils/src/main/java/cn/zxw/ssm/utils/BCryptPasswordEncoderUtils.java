package cn.zxw.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhangxiongwei
 * @data 2018/11/4
 * @time 9:48
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String getEncode(String password) {

        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {

        String aaa = "admin";

        String encode = BCryptPasswordEncoderUtils.getEncode(aaa);
        System.out.println(encode);
    }
}
