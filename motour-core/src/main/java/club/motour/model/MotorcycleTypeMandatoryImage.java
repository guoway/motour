package club.motour.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mandatory")
public class MotorcycleTypeMandatoryImage extends MotorcycleTypeImage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2103590394712053373L;

}
