package club.motour.service;

import java.util.List;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;

import club.motour.model.Manager;
import club.motour.model.User;

public interface ManagerService {

	public PageResponse getAllManagers(PageRequest request);
	
	public List<Manager> getAllManagers();
	
	public Manager findManagerById(String mgrId);
	
	public Manager updateManager(Manager manager);
	
	public Manager createManager(Manager manager);
	
	public void removeManager(String mgrId);
	
	public List<User> getUsersWithoutAdminPermissions();
}
