package club.motour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.motour.dao.ZipCodeDAO;
import club.motour.model.ZipCode;
import club.motour.service.ZipCodeService;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

	@Autowired
	ZipCodeDAO zipCodeDAO;
	
	@Override
	public List<ZipCode> getAllZipCodes() {
		
		return zipCodeDAO.findAll();		
	}
}
