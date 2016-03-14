package club.motour.search.obj;

import java.io.Serializable;

import com.sylksoft.sql.SqlCondition;
import com.sylksoft.sql.SqlSpecification;
import com.sylksoft.sql.SqlSpecification.Operator;


public abstract class NativeSearchWithPageRequest implements Serializable {

	private static final long serialVersionUID = -3898470373315733639L;
	
	protected final StringBuffer conditionStringBuilder = new StringBuffer();
	
	abstract public StringBuffer composeNativeSql(String sql, SqlSpecification spec) ;	
	
	protected synchronized void addCondition(SqlCondition condition) {
		conditionStringBuilder.append(" " + condition.getSql() + " ");
	}

	protected synchronized void addCondition(Operator operator, SqlCondition condition) {
		if (conditionStringBuilder.length() > 0) {
			conditionStringBuilder.append(" " + operator.toString().toUpperCase() + " " + condition.getSql() + " ");
		} else {
			addCondition(condition);
		}
	}

}
