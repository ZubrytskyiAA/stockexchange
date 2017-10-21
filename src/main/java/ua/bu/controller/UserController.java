package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ua.bu.entity.Asset;
import ua.bu.entity.User;
import ua.bu.service.interfaces.AssetService;
import ua.bu.service.interfaces.IssueService;
import ua.bu.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
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
    public String getAllUsers(Model model,
                              @RequestParam(value = "page", required = false) Integer page,
                              @RequestParam(value = "size", required = false) Integer size,
                              @RequestParam(value = "order", required = false) String order,
                              @RequestParam(value = "prevOrder", required = false) String prevOrder,
                              @RequestParam(value = "orderType", required = false) String orderType,
                              @RequestParam(value = "prevOrderType", required = false) String prevOrderType) {
        int totalPages = 0;

        String sortType;


        if(StringUtils.isEmpty(order)){
            sortType = "desc";
            model.addAttribute("prevOrderType", "");
            model.addAttribute("prevOrder", "");
        }
       else if(order.equalsIgnoreCase(prevOrder) && prevOrderType.equalsIgnoreCase("asc")){
           sortType = "desc";
           model.addAttribute("prevOrderType", "desc");
           model.addAttribute("prevOrder", order);
       }else{
           sortType = "asc";
           model.addAttribute("prevOrderType", "asc");
           model.addAttribute("prevOrder", order);
       }


        if (page != null) {

            Page<User> pages = userService.getAll(page, Integer.MAX_VALUE, order, sortType);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
        } else if (!StringUtils.isEmpty(order)) {
            model.addAttribute("users", userService.getAll(0, Integer.MAX_VALUE, order, sortType).getContent());
        } else {
            Collection<User> all = userService.getAll();
            model.addAttribute("users", all);
            totalPages = all.size() ;
        }
        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);
        return "userList";


//        model.addAttribute("users", userService.getAll());
//        return "userList";
    }

    @PostMapping("/deleteUserById")
    public String deleteById(@ModelAttribute User user) {
        userService.deleteById(user.getId());
        return "redirect:/users";
    }

    @PostMapping("/newUser")
    public String createUser(@ModelAttribute User user,
                             HttpServletRequest request) {

        userService.save(user);
        return "redirect:/" +request.getHeader("Referer");
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createUserForm";
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
