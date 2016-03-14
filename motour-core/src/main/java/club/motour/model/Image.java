package club.motour.model;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sylksoft.generic.GenericEntity;

@Entity
@Table(name="mt_image")
public class Image extends GenericEntity<BigDecimal> {
	
	private static final long serialVersionUID = -2751137088419924570L;
	
	private String image;
	
	private InputStream inputStream;
	
	@Override
	@Id
	@Column(name="im_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public BigDecimal getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}


	@Column(name="image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Transient
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	@Transient
	public List<String> getExcludePropertiesWhenSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
