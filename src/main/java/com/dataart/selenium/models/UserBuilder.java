package com.dataart.selenium.models;

import org.testng.annotations.DataProvider;

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
    @DataProvider(name = "userList")
    public static Object[][]  arrayRegistration5UserWithDifrentRoles(){
        return new Object[][]{
                new Object[]{"user1", "Denis", "Fomichov", "123456", "DEVELOPER"},
                new Object[]{"user2", "Maxim", "Ivanov", "234567", "USER"},
                new Object[]{"user3", "Ivan", "Petrov", "Overweight", "USER"},
                new Object[]{"user4", "Mariya", "Sidorov", "Obesity", "DEVELOPER"},
                new Object[]{"user5", "Dasha", "Sergeeva", "Obesity", "USER"},
        };
    }


}
