package club.motour.dao.impl;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.CashFlowDAO;
import club.motour.model.CashFlow;

@Repository
public class CashFlowDAOImpl extends SpringHibernateDAO<CashFlow, String> implements CashFlowDAO {

}
