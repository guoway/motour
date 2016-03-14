package club.motour.dao.impl;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.UserDAO;
import club.motour.model.User;

@Repository
public class UserDAOImpl extends SpringHibernateDAO<User, String> implements UserDAO {

}
