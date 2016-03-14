package club.motour.util;

import club.motour.exception.SequenceNumberException;

public interface ISequenceNumber {

	/**
	 * 取得序號樣式 head+yyyyMMdd+digitNumSequence
	 * @param tableName 
	 * @param colName
	 * @param head  
	 * @param digitNum 
	 * @return
	 * @throws SequenceNumberException 
	 */
	public String getSequenceNumber_date(String tableName, String colName, String head, int digitNum) throws SequenceNumberException ;
	
	/**
	 * 取得序號樣式 head+digitNumSequence
	 * @param tableName
	 * @param colName
	 * @param head
	 * @param digitNum
	 * @return
	 * @throws SequenceNumberException
	 */
	public String getSequenceNumber(String tableName, String colName,String head, int digitNum) throws SequenceNumberException ;
}
