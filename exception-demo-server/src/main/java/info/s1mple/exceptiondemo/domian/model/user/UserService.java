package info.s1mple.exceptiondemo.domian.model.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.addUser(new User(user));
    }
}
