package com.dataart.selenium.models;

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }
    public static User denis() {
        User user = new User("denis", "Denis");
        user.setFname("Denis");
        user.setLname("Fomichov");
        return user;
    }

}
