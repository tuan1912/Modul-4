package tuan.nguyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tuan.nguyen.model.Role;
import tuan.nguyen.model.User;
import tuan.nguyen.service.IRoleService;
import tuan.nguyen.service.IUserService;
import tuan.nguyen.service.RoleService;
import tuan.nguyen.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    IRoleService roleService;
    @Autowired
    IUserService userService;
    @GetMapping("/home")
    public ModelAndView showAll(){

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("users",userService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("roles",roleService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam MultipartFile avatarResource){

        String nameFile = avatarResource.getOriginalFilename();
        try {
            FileCopyUtils.copy(avatarResource.getBytes(), new File("C:\\Users\\Administrator\\Desktop\\Modul4\\quanlyuser\\src\\main\\webapp\\WEB-INF\\img\\" + nameFile));
            user.setAvatarResource("/img/" + nameFile);
            userService.save(user);

        } catch (IOException e) {
            user.setAvatarResource("/img/spring-la-gi.png");
            userService.save(user);
            e.printStackTrace();
        }
        userService.save(user);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam long id){
        userService.delete(id);
        return "redirect:/home";
    }


}
