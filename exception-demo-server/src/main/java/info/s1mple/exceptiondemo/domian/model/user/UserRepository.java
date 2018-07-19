package info.s1mple.exceptiondemo.domian.model.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Jack", "13500000000", 18));
        users.add(new User("Tom", "13500000001", 19));
    }

    public List<User> users() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
