package info.s1mple.exceptiondemo.domian.model.user;

import info.s1mple.exceptiondemo.domian.exception.RequestArgsIllegalException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void register(User user) throws RequestArgsIllegalException {
        if (!user.checkAgeIsLegal()) {
            throw new RequestArgsIllegalException("age cannot be less than zero");
        }
        if (!user.checkUsernameIsNotEmpty()) {
            throw new RequestArgsIllegalException("username can not be empty");
        }

        userRepository.addUser(new User(user));
    }
}
