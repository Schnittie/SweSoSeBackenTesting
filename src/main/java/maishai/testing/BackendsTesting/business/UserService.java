package maishai.testing.BackendsTesting.business;

import maishai.testing.BackendsTesting.integration.UserRepositoryFake;
import maishai.testing.BackendsTesting.util.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositoryFake userRepositoryFake;

    @Autowired
    public UserService (UserRepositoryFake userRepositoryFake){
        this.userRepositoryFake = userRepositoryFake;
    }
    public List<UserName> getUserNames(){
       return userRepositoryFake.getUsers();
    }
}
