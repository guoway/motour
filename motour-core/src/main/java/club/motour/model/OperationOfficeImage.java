package club.motour.model;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DiscriminatorOptions;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_operation_office_to_image")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="use_of")
@DiscriminatorOptions(force=true)
public abstract class OperationOfficeImage extends GenericEntity<BigDecimal> {

	private static final long serialVersionUID = 2880693616707445376L;

	protected Image image;
	
	protected OperationOffice office;
	
	protected InputStream stream;
	
	@Override
	@Id
	@Column(name="oim_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public BigDecimal getId() {
		return super.getId();
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="im_id", referencedColumnName="im_id")
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name="oid")
	public OperationOffice getOffice() {
		return office;
	}

	public void setOffice(OperationOffice office) {
		this.office = office;
	}
	
	@Transient
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
