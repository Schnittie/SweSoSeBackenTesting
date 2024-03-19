package maishai.testing.BackendsTesting;

import maishai.testing.BackendsTesting.adapters.in.rest.UserApiImpl;
import maishai.testing.BackendsTesting.adapters.in.rest.model.UserNameListTO;
import maishai.testing.BackendsTesting.business.UserService;
import maishai.testing.BackendsTesting.util.UserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class UserNameApiImplTest {

	private final UserService userService = mock(UserService.class);
	private final UserApiImpl userApi = new UserApiImpl(userService);

	@ParameterizedTest
	@CsvSource({"123","456"})
	public void wrongIdReturnsEmptyList(Long wrongID){
		ResponseEntity<UserNameListTO> response = Assertions.assertDoesNotThrow(() -> userApi.getUsers(wrongID));
		Assertions.assertNotNull(response.getBody());
		Assertions.assertNotNull(response.getBody().getList());
		Assertions.assertEquals(0,response.getBody().getList().size());
		//userService wasn't called
		verify(userService,times(0));
	}
	@Test
	public void whenRightIdUserServiceIsCalled(){
		when(userService.getUserNames()).thenReturn(Collections.emptyList());
		userApi.getUsers(userApi.properID);
		verify(userService,times(1));
	}

	@Test
	public void weReturnTheNamesWeGetIn(){
		when(userService.getUserNames()).thenReturn(createUserNameList());
		userApi.getUsers(userApi.properID);
		verify(userService,times(1));
	}

	public List<UserName> createUserNameList(){
		ArrayList<UserName> userList = new ArrayList<>();
		userList.add(new UserName("TestEins","NachnameEins", "WIP"));
		userList.add(new UserName("TestZwei","NachnameZwei", null));
		return userList;
	}

}
