package edu.flst.backlog.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import edu.flst.backlog.bo.Job;
import edu.flst.backlog.bo.User;

/**
 * The Class UserForm.
 */
public class UserForm extends Form<User> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2158417311347139782L;

	/** The first name. */
	@NotNull
	@NotEmpty
	@Size(min=2, max=255)
	private String firstName;
	
	/** The last name. */
	@NotNull
	@NotEmpty
	@Size(min=2, max=255)
	private String lastName;
	
	/** The job. */
	@NotNull
	private Job job;
	
	/** The id. */
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int id;
	
	
	/**
	 * Instantiates a new user form.
	 */
	public UserForm() {
		
	}
	
	/**
	 * Instantiates a new user form.
	 *
	 * @param user the user
	 */
	public UserForm(User user) {
		firstName = user.getFirstName();
		lastName = user.getLastName();
		job = user.getJob();
		id = user.getId();
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the job.
	 *
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the new job
	 */
	public void setJob(Job job) {
		this.job = job;
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

	/* (non-Javadoc)
	 * @see edu.flst.backlog.form.Form#getObject()
	 */
	@Override
	public User getObject() {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setId(id);
		user.setJob(job);
		
		return user;
	}
	
}
