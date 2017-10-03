package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Asset;
import ua.bu.entity.User;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private AssetService assetService;


    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @PostMapping("/deleteUserById")
    public String deleteById(@ModelAttribute User user) {
        userService.deleteById(user.getId());
        return "redirect:/users";
    }

    @PostMapping("/newUser")
    public String createUser(@ModelAttribute User user) {

        userService.save(user);
        return "redirect:/users";
    }

//    @PostMapping("/delete")
//    public String deleteUser(@ModelAttribute("id") int id) {
//        userService.deleteById(id);
//        return "redirect:/users";
//    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        List<Asset> assets = assetService.getAssetsByUserId(id);
        if (!assets.isEmpty()) {
            model.addAttribute("listAssets", assetService.getAssetsByUserId(id));
        }
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

    @PostMapping("/withdraw")
    public String addIssueToUser(@ModelAttribute("select1") int issueId, @ModelAttribute("userId") int userId) {

        return "redirect:showUser";
    }

    @PostMapping("/setActivities")
    public String setActive(@ModelAttribute User setActive, Model model) {
        User user = userService.getById(setActive.getId());
        user.setActive(setActive.isActive());
        userService.update(user);
        return "redirect:/users";
    }


}
