package club.motour.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_manager")
public class Manager extends GenericEntity<String> {

	private static final long serialVersionUID = -4700445766193126184L;

	private User user;
	
	private Set<OperationOffice> offices = new TreeSet<>();
	
	
	
	@Override
	@Id
	@Column(name="manager_id")
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="manager_id")	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany
	@JoinTable(
			name="mt_manager_to_operation_office",
			joinColumns=@JoinColumn(name="manager_id"),
			inverseJoinColumns=@JoinColumn(name="oid")
	)
	public Set<OperationOffice> getOffices() {
		return offices;
	}

	public void setOffices(Set<OperationOffice> offices) {
		this.offices = offices;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
