package club.motour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.motour.dao.CodeMetaDAO;
import club.motour.model.CodeMeta;
import club.motour.service.CodeMetaService;

@Service
public class CodeMetaServiceImpl implements CodeMetaService {

	@Autowired
	CodeMetaDAO codeMetaDAO;
	
	@Override
	public List<CodeMeta> getAllCodeMeta() {
		return codeMetaDAO.findAll();
	}

}
