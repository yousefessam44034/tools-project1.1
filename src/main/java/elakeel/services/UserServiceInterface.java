package elakeel.services;

import elakeel.ejbs.User;
import elakeel.ejbs.UserRole;

public interface UserServiceInterface {
	User createUser(User user);
	
	User getUserById(Long id);
	
	User getUserByUsername(String username);
	
	User login(String username, String password, UserRole role);

}
