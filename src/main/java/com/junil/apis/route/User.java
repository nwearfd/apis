package com.junil.apis.route;

import com.junil.apis.model.User;
import com.junil.apis.service.UserService;
import com.junil.apis.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;

    @Autowired
    public UserRoute(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> getUsers(){
        return this.userService.findAll();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public User getUsers(@PathVariable(value="user_id") String userId) throws Exception{
        return this.userService.find(Integer.parseInt(userId));
    }

    @PostMapping("")
    public void createUser(UserRegisterVO user){
        this.userService.createUser(user);
    }

    @GetMapping("/initialize")
    public void initializeUser(){
        this.userService.initializeUsers();
    }

    @GetMapping("/{user_id}")
    public void deleteUser(@PathVariable(value="user_id")String userId){
        this.userService.deleteUser(Integer.parseInt(userId));
    }
}