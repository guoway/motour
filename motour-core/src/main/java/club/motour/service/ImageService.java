package club.motour.service;

import club.motour.model.MotorcycleTypeImage;
import club.motour.model.OperationOfficeImage;

public interface ImageService {

	
	/**
	 * 儲存圖檔
	 * 儲存圖檔時必檢查MotorcycleTypeImage.motorcycleType與MotorcycleTypeImage.image是否有值。
	 * @param images
	 * @return
	 */
	public void saveImage(MotorcycleTypeImage... images) throws NullPointerException;
	
	/**
	 * 儲存圖檔
	 * 儲存圖檔時必檢查OperationOfficeImage.office與OperationOfficeImage.image是否有值。
	 * @param images
	 * @return
	 */
	public void saveImage(OperationOfficeImage... images) throws NullPointerException;
	
}
