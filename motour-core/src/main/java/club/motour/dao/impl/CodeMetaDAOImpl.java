package club.motour.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.sylksoft.generic.SpringHibernateDAO;

import club.motour.dao.CodeMetaDAO;
import club.motour.model.CodeMeta;

@Repository
public class CodeMetaDAOImpl extends SpringHibernateDAO<CodeMeta, BigDecimal> implements CodeMetaDAO {


}
