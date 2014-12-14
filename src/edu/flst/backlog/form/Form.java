package edu.flst.backlog.form;

import java.io.Serializable;

/**
 * The Class Form.
 *
 * @param <E> the element type
 */
public abstract class Form<E> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6581165130873147956L;
	
	/** The action. */
	private String action;

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * Gets the object.
	 *
	 * @return the object
	 */
	public abstract E getObject();
	
}
