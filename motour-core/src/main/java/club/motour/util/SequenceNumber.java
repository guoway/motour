package club.motour.util ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sylksoft.sql.SqlDAOFactory;
import com.sylksoft.sql.SqlParameter;
import com.sylksoft.sql.StringRowMapper;
import com.sylksoft.util.DateUtil;

import club.motour.exception.SequenceNumberException;
import club.motour.model.enums.MessageCode;


public class SequenceNumber implements ISequenceNumber {

	private static SequenceNumber instance ;
	
	public static SequenceNumber getInstance(){
		if(instance ==null){
			instance = new SequenceNumber() ;
		}
		return instance;
	}
	
	protected Logger log = Logger.getLogger(SequenceNumber.class) ;
	
	@SuppressWarnings("rawtypes")
	public String getSequenceNumber(String tableName, String colName,
			String head, int digitNum) throws SequenceNumberException{
		String sequenceNumber = "";
		
		try {
			
			SqlParameter<String> dataParam = new SqlParameter<String>() ;
			String sql = "";
		    
			if(head == null){
		    	sql = "SELECT IFNULL(MAX(" + colName + "),0) FROM " + tableName;
				dataParam.setArguments(new Object[]{}) ;
			}else{
				sql = "SELECT IFNULL(MAX(SUBSTRING(" + colName + ",?,LENGTH(" + colName + "))),0) FROM " + tableName + " WHERE " + colName + " LIKE ?";
				dataParam.setArguments(new Object[]{(head.length()+1),head+"%"}) ;
			}
			
			dataParam.setStatement(sql) ;
			dataParam.setMapper(new StringRowMapper()) ;
			List list = SqlDAOFactory.getInstance().getSqlDAO().queryAsList(dataParam) ;
			
			 
			 long currNumber = Long.valueOf(filtrateNonDigit(list.get(0).toString()));
			 
		      if (currNumber < 1) {
		        sequenceNumber = (head == null?"":head) + fillSequenceNumber("1", digitNum, '0');
		      }else {
		      	sequenceNumber = Long.toString(++currNumber);
		      	sequenceNumber = fillSequenceNumber(sequenceNumber, digitNum, '0');
		      	if(!(sequenceNumber.length() <= digitNum)){
		      		throw new SequenceNumberException("超過設定的最大位數", MessageCode.CREATE_ORDER_ERROR) ;
		      	}
		      		
		      	sequenceNumber = (head == null?"":head) + sequenceNumber;
		      }

		} catch (Exception e) {
			log.error(e.getMessage(),e) ;
		}
		 return sequenceNumber ;

	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getSequenceNumber_date(String tableName, String colName,
			String head, int digitNum) throws SequenceNumberException {
		String sequenceNumber = "";
		
		try {
			String format = "yyyyMMdd" ;
			head = headJoinDate(head, format) ;
			
			SqlParameter<String> dataParam = new SqlParameter<String>() ;
			String sql = "";
		    
			if(head == null){
		    	sql = "SELECT IFNULL(MAX(" + colName + "),0) FROM " + tableName;
				dataParam.setArguments(new Object[]{}) ;
			}else{
				sql = "SELECT IFNULL(MAX(SUBSTRING(" + colName + ",?,LENGTH(" + colName + "))),0) FROM " + tableName + " WHERE " + colName + " LIKE ?";
				dataParam.setArguments(new Object[]{(head.length()+1),head+"%"}) ;
			}
			dataParam.setStatement(sql) ;
			dataParam.setMapper(new StringRowMapper()) ;
			List list = SqlDAOFactory.getInstance().getSqlDAO().queryAsList(dataParam) ;
			
			 
			 long currNumber = Long.valueOf(filtrateNonDigit(list.get(0).toString()));
			 
		      if (currNumber < 1) {
		        sequenceNumber = (head == null?"":head) + fillSequenceNumber("1", digitNum, '0');
		      } 
		      else {
		      	sequenceNumber = Long.toString(++currNumber);
		      	sequenceNumber = fillSequenceNumber(sequenceNumber, digitNum, '0');
		      	if(!(sequenceNumber.length() <= digitNum)){
		      		throw new SequenceNumberException("超過設定的最大位數", MessageCode.CREATE_ORDER_ERROR) ;
		      	}
		      		
		      	sequenceNumber = (head == null?"":head) + sequenceNumber;
		      }

		} catch (Exception e) {
			log.error(e.getMessage(),e) ;
		}
		 return sequenceNumber ;
	}

	private String filtrateNonDigit(String sequenceNumber) {
	  	int length = sequenceNumber.length();
	    String sequenceNumber_Temp = "";
	    for(int i = 0; i < length; i++){
	    	if(Character.isDigit(sequenceNumber.charAt(i))){
	    		sequenceNumber_Temp += sequenceNumber.charAt(i);
	    	}
	    }
	    return sequenceNumber_Temp;
	}
	
	 
	
	 @SuppressWarnings("unused")
	private String headJoinROCDate(String head, String format){
		    SimpleDateFormat sdf = new SimpleDateFormat(format);
		    String strDate = sdf.format(new Date());
		    String head_Date = DateUtil.formatToROCDate("", strDate, "") ;
		    String head_Temp = (head == null?"":head) + head_Date;
		    return head_Temp;
	 }
	 
	 private String headJoinDate(String head, String format){
		  	SimpleDateFormat sdf = new SimpleDateFormat(format);
		    String head_Date = sdf.format(new Date());
		    String head_Temp = (head == null?"":head) + head_Date;
		    return head_Temp;
	 }
	 
	 private String fillSequenceNumber(String sequenceNumber, int digitNum, char fillChar) {
		    String sequenceNumber_Temp = sequenceNumber;
		  	int tempLength = sequenceNumber_Temp.length();
		    for (int i = 0; i < digitNum - tempLength; i++) {
		    	sequenceNumber_Temp = fillChar + sequenceNumber_Temp;
		    }
		    return sequenceNumber_Temp;
	 }
}
