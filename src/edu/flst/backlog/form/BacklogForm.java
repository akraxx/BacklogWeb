package edu.flst.backlog.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import edu.flst.backlog.bo.Backlog;

/**
 * The Class BacklogForm.
 */
public class BacklogForm implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9081437066847456215L;
	
	/** The description. */
	@NotNull
	@NotEmpty
	@Size(min=2, max=255)
	private String description;
	
	/** The owner. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int idOwner;

	/**
	 * Instantiates a new backlog form.
	 */
	public BacklogForm() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new backlog form.
	 *
	 * @param backlog the backlog
	 */
	public BacklogForm(Backlog backlog) {
		description = backlog.getDescription();
		if(backlog.getOwner() != null) {
			idOwner = backlog.getOwner().getId();
		}
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the id owner.
	 *
	 * @return the id owner
	 */
	public int getIdOwner() {
		return idOwner;
	}

	/**
	 * Sets the id owner.
	 *
	 * @param idOwner the new id owner
	 */
	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

}
