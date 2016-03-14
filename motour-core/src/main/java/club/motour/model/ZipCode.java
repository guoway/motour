package club.motour.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="ss3a_zip_code")
public class ZipCode extends GenericEntity<BigDecimal> implements Cloneable {

	private static final long serialVersionUID = -7930351283554837703L;

	private String zip;
	
	private String name;
	
	private ZipCode parent;
	
	
	@Override
	@Id
	@Column(name="zid")
	public BigDecimal getId() {
		return super.getId();
	}
	
	@Column(name="zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToOne
	@JoinColumn(name="parent_zid")
	public ZipCode getParent() {
		return parent;
	}

	public void setParent(ZipCode parent) {
		this.parent = parent;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ZipCode clone() throws CloneNotSupportedException {
		return (ZipCode) super.clone();
	}


}
