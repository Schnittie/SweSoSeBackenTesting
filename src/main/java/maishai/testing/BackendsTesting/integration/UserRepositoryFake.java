package maishai.testing.BackendsTesting.integration;

import maishai.testing.BackendsTesting.util.UserName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryFake {
    public UserRepositoryFake(){}

    public List<UserName> getUsers(){
        ArrayList<UserName> userList = new ArrayList<>();
        userList.add(new UserName("Laura","Schleicher", "WIP"));
        userList.add(new UserName("Lena","Schlinger", "Wife"));
        userList.add(new UserName("Robyn","Idk", "Die Nase"));
        userList.add(new UserName("Christa","Schnabel", "Historia"));
        return userList;
    }
}
