package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Issue;
import ua.bu.entity.User;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IssueService issueService;


    @GetMapping("/allusers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @PostMapping("/deleteUserById")
    public String deleteById(@ModelAttribute User user) {
        userService.deleteById(user.getId());
        return "redirect:allusers";
    }

    @PostMapping("/newUser")
    public String createUser(@ModelAttribute User user) {

        userService.save(user);
        return "redirect:allusers";
    }
    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("id") int id) {
        userService.deleteById(id);
        return "redirect:allusers";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("listIssue", issueService.getAll());
        return "showUser";
    }
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        System.out.println("id = " + id);
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user, Model model) {
        userService.update(user);
        return "redirect:edit/" + user.getId();
    }
    @PostMapping("/addIssueToUser")
    public String addIssueToUser( @ModelAttribute("select1") int issueId, @ModelAttribute("userId") int userId) {
        Issue issue = issueService.getById(issueId);
        User user = userService.getById(userId);
       // user.getIssueList().add(issue);
        System.out.println(issue);
        System.out.println(user);
        return "redirect:showUser/user/" ;
    }



}
