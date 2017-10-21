package ua.bu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.service.interfaces.UserService;

import java.util.List;

@RestController
public class ValuesController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

//В приложении не активен, раздупляюсь с ajax
//    @GetMapping("/values")
//    public String getAllQuotes() throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<User> userList = userDao.getAll();
//        mapper.writeValue(new File("c:\\user.json"), userList);
//        String jsonInString = mapper.writeValueAsString(userList);
//
//
//        return  jsonInString;
//    }


    @GetMapping("/values")
    public String createPage(@RequestParam(value = "login", required = false) String login,
                             @RequestParam(value = "password", required = false) String password,
                             @RequestParam(value = "fname", required = false) String fname,
                             @RequestParam(value = "lname", required = false) String lname,
                             @RequestParam(value = "email", required = false) String email,
                             Model model) {
        String dd = "false";
        if (login != null) {
            List<String> list = userService.getListNamesAllUsers();
            if (list.contains(login)) dd = "true";
            userService.save(login, password, email, fname, lname);
            return dd;

        } else {
            return "false";
        }
    }


}
