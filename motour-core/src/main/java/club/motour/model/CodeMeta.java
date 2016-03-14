package club.motour.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_code_meta")
public class CodeMeta extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 6312166475639872907L;

	private String codeName;
	
	private CodeMeta parent;
	
	private Boolean enabled;
	
	private Integer sortOrder;
	
	public CodeMeta() {
		// TODO Auto-generated constructor stub
	}
	
	public CodeMeta(BigDecimal id) {
		setId(id);
	}

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	public BigDecimal getId() {
		return super.getId();
	}
	
	@Column(name="code_name")
	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}


	@ManyToOne
	@JoinColumn(name="parent_cid")
	public CodeMeta getParent() {
		return parent;
	}

	public void setParent(CodeMeta parent) {
		this.parent = parent;
	}


	@Column(name="enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	@Column(name="sort_order")
	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
