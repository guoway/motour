package club.motour.ui.model;

import java.io.Serializable;

import com.sylksoft.sql.annotation.ColumnMapping;

/**
 * It's used for Select2 jquery library.
 * @author Ken
 *
 */
public class Select2Item implements Serializable {

	private static final long serialVersionUID = -2135175386572716412L;

	
	@ColumnMapping(columnIndex=1)
	private String id;
	
	@ColumnMapping(columnIndex=2)
	private String text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
