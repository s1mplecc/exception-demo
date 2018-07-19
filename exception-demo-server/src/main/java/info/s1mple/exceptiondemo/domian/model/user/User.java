package info.s1mple.exceptiondemo.domian.model.user;

import lombok.Data;

@Data
public class User {

    private static int userIdGenerateKey = 1;

    private Integer userId;
    private String username;
    private String phone;
    private Integer age;

    public User() {
    }

    User(String username, String phone, Integer age) {
        this.userId = User.userIdGenerateKey++;
        this.username = username;
        this.phone = phone;
        this.age = age;
    }

    User(User userWithoutId) {
        this(userWithoutId.username, userWithoutId.phone, userWithoutId.age);
    }
}
