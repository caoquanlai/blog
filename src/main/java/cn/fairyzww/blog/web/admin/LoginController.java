package cn.fairyzww.blog.web.admin;

import cn.fairyzww.blog.entity.User;
import cn.fairyzww.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: Yg
 * @Date: 2019/11/26
 * @Time: 15:20
 * @Description: No Description
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, password);
        if (null != user) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else {
            //使用重定向Model是无法获取的
            redirectAttributes.addFlashAttribute("message", "用户名密码不正确！");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
