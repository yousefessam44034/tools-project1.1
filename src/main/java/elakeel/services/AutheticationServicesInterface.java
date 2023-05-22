package elakeel.services;

import elakeel.ejbs.User;

public interface AutheticationServicesInterface {

User signUp(User user);
	
User login(String username, String password);
}
