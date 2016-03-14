package club.motour.service;

import com.sylksoft.generic.PageRequest;
import com.sylksoft.generic.PageResponse;

import club.motour.exception.LoginException;
import club.motour.exception.MotourException;
import club.motour.exception.VerificationCodeException;
import club.motour.exception.WebUserException;
import club.motour.model.Manager;
import club.motour.model.User;

public interface UserService {

	/**
	 * 前台註冊時的user建立。
	 * 此時尚未開通帳號。
	 * @param User
	 * @return
	 * @throws Exception
	 */
	public User createWebUser(User user) throws Exception;
	
	/**
	 * 前台fb登入，快速註冊
	 * 1. 產生亂數密碼
	 * 2. 寄發Email 通知，更改密碼
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User createFBWebUser(User user) throws Exception;
	
	/**
	 * 開通帳號
	 * @param userId User ID
	 * @param verificationCode 驗證碼
	 * @throws Exception
	 */
	public void enableWebUser(String userId, String verificationCode) throws VerificationCodeException;
	
	/**
	 * 重送驗證信
	 * @param userId
	 * @throws VerificationCodeException
	 */
	public void resendVerificationCode(String userId) throws VerificationCodeException;
	
	/**
	 * 前台使用者登入
	 * @param userId
	 * @param passwd
	 * @return
	 * @throws LoginException
	 */
	public User loginWebUser(String userId, String passwd) throws LoginException;
	
	/**
	 * 忘記密碼
	 * @param userId
	 * @throws WebUserException
	 */
	public void forgetPassword(String userId) throws WebUserException;
	
	/**
	 * 驗證是否進入重設密碼頁面
	 * @param userId
	 * @param vCode
	 * @return
	 * @throws VerificationCodeException 
	 */
	public void confirmResetPassword(String userId, String vCode) throws VerificationCodeException;
	
	/**
	 * 依userid查詢user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User findUserByUserId(String userId) throws Exception ;
	
	/**
	 * 重設密碼
	 * @param userId
	 * @param password
	 */
	public void resetPassword(String userId, String password);
	
	/**
	 * 刪除使用者。
	 * 用於開發階段測試用。
	 * @param userId
	 */
	public void deleteUser(String userId) throws MotourException;
	
	/**
	 * 更新User Profile
	 * @param user
	 * @return
	 */
	public User updateUserProfile(User user);
	
	/**
	 * 後台使用者登入
	 * @param userId
	 * @param passwd
	 * @return
	 * @throws LoginException
	 */
	public Manager loginAdminUser(String userId, String passwd) throws LoginException;
	
	/**
	 * 列出所有後台User(擁有adm_uesr)權限
	 * @param request
	 * @return
	 */
	public PageResponse getAllManagers(PageRequest request);
	
	/**
	 * 列出所有使用者
	 * @param request
	 * @return
	 */
	public PageResponse getAllUsers(PageRequest request);
	
	/**
	 * 模糊比對取出所有相應User ID
	 * @param id
	 * @param request
	 * @return
	 */
	public PageResponse getUsersByIdLike(String id, PageRequest request);
	
}
