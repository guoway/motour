package club.motour.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import club.motour.model.Image;
import club.motour.model.MotorcycleType;
import club.motour.model.MotorcycleTypeMandatoryImage;
import club.motour.model.OperationOffice;
import club.motour.model.OperationOfficeIntroImage;
import club.motour.model.OperationOfficeMandatoryImage;
import club.motour.test.TestTemplate;

public class ImageServiceTest extends TestTemplate {

	@Autowired
	ImageService service;
	
	//@Test
	@Commit
	public void testSaveMotorcycleTypeMandatoryImage() throws IOException {
		
		File f = new File("C:\\workspace\\workspace_motour\\data\\images\\sha_img1_450x300.jpg");
		
		FileInputStream fis = new FileInputStream(f);
		
		MotorcycleTypeMandatoryImage im = new MotorcycleTypeMandatoryImage();
		im.setMotorcycleType(new MotorcycleType(new BigDecimal(7)));
		
		Image image = new Image();
		image.setInputStream(fis);
		im.setImage(image);
		
		service.saveImage(im);
		
	}
	
	@Test
	@Commit
	public void testSaveOperationOfficeMandatoryImage() throws IOException {
		
		File f = new File("C:\\Users\\guoway\\Downloads\\營運據點\\圖檔\\澎湖\\pen_img4_800x400.jpg");
		
		FileInputStream fis = new FileInputStream(f);
		
		OperationOfficeIntroImage im = new OperationOfficeIntroImage();
		im.setOffice(new OperationOffice(new BigDecimal(2)));
		
		Image image = new Image();
		image.setInputStream(fis);
		im.setImage(image);
		
		service.saveImage(im);
		
	}
}
