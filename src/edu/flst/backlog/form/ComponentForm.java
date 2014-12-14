/*
 * 
 */
package edu.flst.backlog.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import edu.flst.backlog.bo.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentForm.
 *
 * @author Maximilien
 */
public class ComponentForm extends Form<Component> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8082012968109489317L;
	
	/** The id. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int id;
	
	/** The label. */
	@NotNull
	@NotEmpty
	@Size(min=2)
	private String label;
	
	/** The owner. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int idOwner;
	
	/** The description. */
	@NotNull
	@NotEmpty
	@Size(min=2	)
	private String description;
	
	/**
	 * Instantiates a new component form.
	 */
	public ComponentForm() {
		
	}

	/**
	 * Instantiates a new component form.
	 *
	 * @param component the component
	 */
	public ComponentForm(Component component) {
		id = component.getId();
		label = component.getLabel();
		description = component.getDescription();
		idOwner = component.getOwner().getId();
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
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

	/* (non-Javadoc)
	 * @see edu.flst.backlog.form.Form#getObject()
	 */
	@Override
	public Component getObject() {
		Component component = new Component();
		component.setDescription(description);
		component.setOwner(null);
		component.setId(id);
		component.setLabel(label);
		
		return component;
	}
	
}
