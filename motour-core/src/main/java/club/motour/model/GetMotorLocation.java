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
@Table(name="mt_get_motor_location")
public class GetMotorLocation extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 3022086097063279080L;

	private String name;
	
	private boolean enabled;
	
	private OperationOffice office ;
	
	@Override
	@Id
	@Column(name="gm_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public BigDecimal getId() {
		return super.getId();
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToOne
	@JoinColumn(name="oid")
	public OperationOffice getOffice() {
		return office;
	}

	public void setOffice(OperationOffice office) {
		this.office = office;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
