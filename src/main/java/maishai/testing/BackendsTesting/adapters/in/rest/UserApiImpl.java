package maishai.testing.BackendsTesting.adapters.in.rest;

import maishai.testing.BackendsTesting.adapters.in.rest.api.UsersApi;
import maishai.testing.BackendsTesting.adapters.in.rest.model.UserNameListTO;
import maishai.testing.BackendsTesting.business.UserService;
import maishai.testing.BackendsTesting.mapping.mapper.UserNameMapper;
import maishai.testing.BackendsTesting.util.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class UserApiImpl implements UsersApi {

    public final Long properID = 123456789L;
    public final UserService userService;
    @Autowired
    public UserApiImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserNameListTO> getUsers(Long getUserId) {
        if (getUserId == null)
            throw new RuntimeException();
            //TODO
        if (properID.longValue() != getUserId.longValue()){
            //TODO
            return ResponseEntity.ok(new UserNameListTO(Collections.emptyList()));
        }

        UserNameListTO userNameListTO = new UserNameListTO();
        for (UserName userName : userService.getUserNames()) {
            userNameListTO.addListItem(UserNameMapper.INSTANCE.fromInToOut(userName));
        }
        return ResponseEntity.ok(userNameListTO);
    }
}
