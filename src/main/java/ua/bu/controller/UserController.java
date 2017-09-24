package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bu.entity.User;
import ua.bu.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @PostMapping("/deleteUserById")
    public String deleteById(@ModelAttribute User user) {
        userService.deleteById(user.getId());
        return "redirect:users";
    }





}
