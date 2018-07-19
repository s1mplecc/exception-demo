package info.s1mple.exceptiondemo.rest.controllers;

import info.s1mple.exceptiondemo.domian.model.user.User;
import info.s1mple.exceptiondemo.domian.model.user.UserRepository;
import info.s1mple.exceptiondemo.domian.model.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @GetMapping
    public List<User> users() {
        return userRepository.users();
    }

    @PostMapping
    public void register(@RequestBody User user) {
        userService.register(user);
    }
}
