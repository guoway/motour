package club.motour.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("intro")
public class OperationOfficeIntroImage extends OperationOfficeImage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2430096234458409491L;

}
