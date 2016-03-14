package club.motour.service.impl;

import java.util.List;
import java.util.function.Predicate;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;
import com.sylksoft.ss3a.dao.Ss3aMemberDAO;
import com.sylksoft.ss3a.model.Role;
import com.sylksoft.ss3a.model.Ss3aMember;

import club.motour.dao.ManagerDAO;
import club.motour.dao.UserDAO;
import club.motour.model.Manager;
import club.motour.model.User;
import club.motour.model.enums.RoleType;
import club.motour.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDAO managerDAO;
	
	@Autowired
	Ss3aMemberDAO ss3aMemberDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public PageResponse getAllManagers(PageRequest request) {
		DetachedCriteria crit = DetachedCriteria.forClass(Manager.class);
		return managerDAO.findByCriteria(crit, request);
	}

	@Override
	public List<Manager> getAllManagers() {
		DetachedCriteria crit = DetachedCriteria.forClass(Manager.class);		
		return managerDAO.findByCriteria(crit);
	}

	@Override
	public Manager findManagerById(String mgrId) {
		DetachedCriteria crit = DetachedCriteria.forClass(Manager.class);
		crit.add(Restrictions.eq("id", mgrId));
		crit.setFetchMode("offices", FetchMode.JOIN);
		List<Manager> list = managerDAO.findByCriteria(crit);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public Manager updateManager(Manager manager) {
		manager = managerDAO.makePersistent(manager);
		return manager;
	}

	@Override
	@Transactional
	public Manager createManager(Manager manager) {
		
		manager.setUser(userDAO.findById(manager.getId()));
		
		//給予權限
		manager.getUser().getSs3aMember().getRoles().add(new Role(RoleType.ADM_USER.getName()));		
		ss3aMemberDAO.makePersistent(manager.getUser().getSs3aMember());
		managerDAO.makePersistent(manager);
		return manager;
	}

	@Override
	@Transactional
	public void removeManager(String mgrId) {
		Ss3aMember member = ss3aMemberDAO.findById(mgrId);
		member.getRoles().removeIf(new Predicate<Role>() {

			@Override
			public boolean test(Role r) {
				if(r.getId().equals("adm_user")) {
					return true;
				}
				
				if(r.getId().equals("administrator")) {
					return true;
				}
				return false;
			}
		});
		
		ss3aMemberDAO.makePersistent(member);
		
		managerDAO.deleteById(mgrId);
	}

	@Override
	public List<User> getUsersWithoutAdminPermissions() {
		DetachedCriteria crit = DetachedCriteria.forClass(User.class);
		crit.createCriteria("ss3aMember").createCriteria("roles").add(Restrictions.eq("id", "adm_user"));
		List<User> list = userDAO.findByCriteria(crit);
		return list;
	}

}
