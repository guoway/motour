package club.motour.dao;

import java.math.BigDecimal;
import java.util.List;

import com.sylksoft.generic.GenericDAO;

import club.motour.model.UserVerificationCode;

public interface UserVerificationCodeDAO extends GenericDAO<UserVerificationCode, BigDecimal> {

	/**
	 * 
	 * @param userId
	 * @param vType
	 * @return UserVerificationCode
	 */
	public UserVerificationCode findOneByUserIdAndVType(String userId, BigDecimal vType);
	
	/**
	 * 
	 * @param userId
	 * @param vType 可傳入NULL，表不分類型
	 * @return List<UserVerificationCode>
	 */
	public List<UserVerificationCode> findListByUserIdAndVType(String userId, BigDecimal vType);
	
	/**
	 * 依User ID與驗證碼類型刪除。
	 * @param userId
	 * @param vType
	 * @return 刪除的數量
	 */
	public int deleteByUserIdAndVType(String userId, BigDecimal vType);
}