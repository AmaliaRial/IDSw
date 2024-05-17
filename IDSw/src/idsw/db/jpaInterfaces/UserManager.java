package idsw.db.jpaInterfaces;

import java.util.List;

import idsw.db.pojos.Role;
import idsw.db.pojos.User;

public interface UserManager {

	public void register(User u);
	public void createRole(Role r);
	public Role getRole(String name);
	public List<Role>  getAllRoles();
	public void assignRole(User u, Role r);
	//Return null if there is no user
	public User login(String username); // or do a throws UserNotFoundException
	public boolean verifyPassword(String inputPassword, String username);
	public User getUser(String username);
}
