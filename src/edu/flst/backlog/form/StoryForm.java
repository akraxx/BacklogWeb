package edu.flst.backlog.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import edu.flst.backlog.bo.Status;
import edu.flst.backlog.bo.Story;

/**
 * The Class StoryForm.
 */
public class StoryForm extends Form<Story> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3380956739993981678L;

	/** The id. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int id;
	
	/** The label. */
	@NotNull
	@NotEmpty
	@Size(min=5, max=255)
	private String label;
	
	/** The comment. */
	@NotNull
	@NotEmpty
	@Size(min=5, max=1000)
	private String comment;
	
	/** The created date. */
	private Date createdDate;
	
	/** The modified date. */
	private Date modifiedDate;
	
	/** The user. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int idUser;
	
	/** The status. */
	@NotNull
	private Status status;
	
	/** The component. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int idComponent;
	
	/**
	 * Instantiates a new story form.
	 */
	public StoryForm() {
		createdDate = new Date();
		modifiedDate = new Date();
	}
	
	/**
	 * Instantiates a new story form.
	 *
	 * @param story the story
	 */
	public StoryForm(Story story) {
		id = story.getId();
		label = story.getLabel();
		comment = story.getComment();
		createdDate = story.getCreatedDate();
		modifiedDate = story.getModifiedDate();
		idUser = story.getUser().getId();
		status = story.getStatus();
		idComponent = story.getComponent().getId();
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
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}


	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}


	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}


	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	/**
	 * Gets the id user.
	 *
	 * @return the id user
	 */
	public int getIdUser() {
		return idUser;
	}


	/**
	 * Sets the id user.
	 *
	 * @param idUser the new id user
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}


	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}


	/**
	 * Gets the id component.
	 *
	 * @return the id component
	 */
	public int getIdComponent() {
		return idComponent;
	}


	/**
	 * Sets the id component.
	 *
	 * @param idComponent the new id component
	 */
	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}


	/* (non-Javadoc)
	 * @see edu.flst.backlog.form.Form#getObject()
	 */
	@Override
	public Story getObject() {
		Story story = new Story();
		story.setComment(comment);
		story.setCreatedDate(createdDate);
		story.setModifiedDate(modifiedDate);
		story.setStatus(status);
		story.setId(id);
		story.setLabel(label);
		return story;
	}

}
