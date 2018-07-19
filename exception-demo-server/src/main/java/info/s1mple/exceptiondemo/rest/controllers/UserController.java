package info.s1mple.exceptiondemo.rest.controllers;

import info.s1mple.exceptiondemo.domian.exception.RequestArgsIllegalException;
import info.s1mple.exceptiondemo.domian.model.user.User;
import info.s1mple.exceptiondemo.domian.model.user.UserRepository;
import info.s1mple.exceptiondemo.domian.model.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;

    @GetMapping
    public List<User> users() {
        return userRepository.users();
    }

    @PostMapping
    public void register(@RequestBody User user, HttpServletResponse response) throws IOException {
        try {
            userService.register(user);
        } catch (RequestArgsIllegalException e) {
            logger.warn("{}. {}", e.getMessage(), user);
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
