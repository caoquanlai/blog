package cn.fairyzww.blog.service;

import cn.fairyzww.blog.dao.UserRepository;
import cn.fairyzww.blog.entity.User;
import cn.fairyzww.blog.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 15:16
 * @Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, Md5Util.code(password));
        return user;
    }
}
