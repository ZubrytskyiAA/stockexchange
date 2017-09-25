package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/newUser")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:users";
    }
    @PostMapping("/delete")
    public String deleteUser2(@ModelAttribute("id") int id) {
        userService.deleteById(id);
        return "redirect:users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }


}
