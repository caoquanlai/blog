package cn.fairyzww.blog.dao;

import cn.fairyzww.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 15:17
 * @Description: No Description
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过username和password查询User
     * @param username username
     * @param password md5后的password
     * @return User
     */
    User findByUsernameAndPassword(String username, String password);
}
