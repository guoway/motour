package club.motour.search.obj;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

public abstract class SearchWithPageRequest implements Serializable {

	private static final long serialVersionUID = -8572665027882358008L;

	/**
	 * 將輸入的條件加入參數crit中。
	 * @param crit
	 * @return
	 */
	abstract public DetachedCriteria composeDetachedCriteria(DetachedCriteria crit);
	
	/**
	 * 將輸入的條件組成SQL。
	 * @return
	 */
	abstract public String composeSQL();
}
