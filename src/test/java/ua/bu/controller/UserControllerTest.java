package ua.bu.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.bu.config.JpaConfigTest;
import ua.bu.config.SpringConfig;
import ua.bu.config.WebAppConfig;
import ua.bu.config.security.SecurityConfig;
import ua.bu.config.security.SecurityInitializer;
import ua.bu.service.interfaces.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, JpaConfigTest.class, WebAppConfig.class, SecurityConfig.class, SecurityInitializer.class})
@WebAppConfiguration
public class UserControllerTest {
    @Test
    public void createPage() throws Exception {

        mockMvc.perform(get("/users/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("createUserForm"));
    }


    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void getAllUsers() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void createUser() throws Exception {
    }

    @Test
    @WithMockUser(username = "saniya", password = "123")
    public void getUserById() throws Exception {

//
//        System.out.println("===========================");
//        //doReturn(user).when(userService.getById(anyInt()));
//        //when(userService.getById(anyInt())).thenReturn(user);
//
//
//        mockMvc.perform(get("/users/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(view().name("showUser"))
//                .andExpect(model().attributeExists("user"));
//
////        mockMvc.perform(get("/users/{id}", 1).param("edit", String.valueOf(true)))
////                .andExpect(status().isOk())
////                .andExpect(view().name("editUser"))
////                .andExpect(model().attributeExists("user"));
//        //verify(userService, times(1)).getById(1);

    }


    @Test
    public void mockApplicationUser() {


    }


    @Test
    public void editPage() throws Exception {
    }

    @Test
    public void editUser() throws Exception {
    }

    @Test
    public void addIssueToUser() throws Exception {
    }

    @Test
    public void setActive() throws Exception {
    }


}