package club.motour.dao;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import club.motour.model.CodeMeta;
import club.motour.test.TestTemplate;

public class CodeMetaDAOTest extends TestTemplate{

	@Autowired
	CodeMetaDAO codeMetaDAO;
	
	@Test
	public void testFindById() {
		CodeMeta c = codeMetaDAO.findById(new BigDecimal(7));
		
		System.out.println(c.getParent().getCodeName());
	}
	
}
