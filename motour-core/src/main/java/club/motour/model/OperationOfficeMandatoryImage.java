package club.motour.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mandatory")
public class OperationOfficeMandatoryImage extends OperationOfficeImage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4466726227925760701L;

}
