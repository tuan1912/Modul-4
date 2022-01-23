package tuan.nguyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import tuan.nguyen.model.User;
import tuan.nguyen.service.RoleServiceImpl;
import tuan.nguyen.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/users")
    @ModelAttribute
    public ModelAndView list(){
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

}
