package cn.fairyzww.blog.service;

import cn.fairyzww.blog.entity.User;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 15:14
 * @Description: No Description
 */
public interface UserService {

    /**
     * 核对账户密码
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User checkUser(String username, String password);
}
