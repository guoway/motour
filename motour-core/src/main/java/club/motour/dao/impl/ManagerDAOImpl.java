package club.motour.dao.impl;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.ManagerDAO;
import club.motour.model.Manager;

@Repository
public class ManagerDAOImpl extends SpringHibernateDAO<Manager, String> implements ManagerDAO {

}
