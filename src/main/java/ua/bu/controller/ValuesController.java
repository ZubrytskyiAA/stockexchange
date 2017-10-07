package ua.bu.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.bu.dao.interfaces.UserDao;
import ua.bu.entity.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ValuesController {

    @Autowired
    UserDao userDao;


    @GetMapping("/values")
    public String getAllQuotes() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = userDao.getAll();
        mapper.writeValue(new File("c:\\user.json"), userList);
        String jsonInString = mapper.writeValueAsString(userList);


        return  jsonInString;
    }






}
