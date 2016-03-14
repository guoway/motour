package club.motour.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sylksoft.util.DateUtil;

import club.motour.dao.ImageDAO;
import club.motour.dao.MotorcycleTypeImageDAO;
import club.motour.dao.OperationOfficeImageDAO;
import club.motour.model.MotorcycleTypeImage;
import club.motour.model.OperationOfficeImage;
import club.motour.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	ImageDAO imageDAO;
	
	@Autowired
	MotorcycleTypeImageDAO motorcycleTypeImageDAO;
	
	@Autowired
	OperationOfficeImageDAO operationOfficeImageDAO;
	
	@Value("${file.image.store}")
	String imageFolder;

	@Override
	@Transactional
	public void saveImage(MotorcycleTypeImage... images) throws NullPointerException {
		for(MotorcycleTypeImage image : images) {
			if(image.getMotorcycleType() == null) {
				throw new NullPointerException("MotorcycleTypeImage.motorcycleType cannot be null");
			}
			if(image.getImage() == null) {
				throw new NullPointerException("MotorcycleTypeImage.image cannot be null");
			}
		}
		
		for(MotorcycleTypeImage image : images) {
			String filename = generateDefaultImageFileName("mt", image.getMotorcycleType().getId());
			String filepath = imageFolder + "/" + filename;
			File f = new File(filepath);
			
			try {
				Files.copy(image.getImage().getInputStream(), f.toPath());
				image.getImage().setImage("images/" + filename);
			} catch (IOException e) {
				log.error("Cannot write image file");
				log.error(e.getMessage(), e);
			}
			motorcycleTypeImageDAO.makePersistent(image);
		}
	}
	
	@Override
	@Transactional
	public void saveImage(OperationOfficeImage... images) throws NullPointerException {
		for(OperationOfficeImage image : images) {
			if(image.getOffice() == null) {
				throw new NullPointerException("OperationOfficeImage.office cannot be null");
			}
			if(image.getImage() == null) {
				throw new NullPointerException("OperationOfficeImage.image cannot be null");
			}
		}
		
		for(OperationOfficeImage image : images) {
			String filename = generateDefaultImageFileName("oo", image.getOffice().getId());
			String filepath = imageFolder + "/" + filename;
			File f = new File(filepath);
			
			try {
				Files.copy(image.getImage().getInputStream(), f.toPath());
				image.getImage().setImage("images/" + filename);
			} catch (IOException e) {
				log.error("Cannot write image file");
				log.error(e.getMessage(), e);
			}
			operationOfficeImageDAO.makePersistent(image);
		}
		
	}
	
	private String generateDefaultImageFileName(String typeString, BigDecimal id) {
		StringBuilder sb = new StringBuilder();
		sb.append(typeString + "-");
		sb.append(id + "-");
		sb.append(DateUtil.formatDate(new Date(), "yyyyMMddhhmmss"));
		sb.append(".png");
		return sb.toString();
	}




	
}
