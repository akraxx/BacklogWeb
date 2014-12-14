/*
 * 
 */
package edu.flst.backlog.service;

import java.text.SimpleDateFormat;
import java.util.List;

import edu.flst.backlog.bo.Backlog;
import edu.flst.backlog.bo.Component;
import edu.flst.backlog.bo.Story;
import edu.flst.backlog.bo.User;


// TODO: Auto-generated Javadoc
/**
 * The Interface BacklogService.
 */
public interface BacklogService {
	
	/** The Constant DEFAULT_DATE_FORMAT. */
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User createUser(User user);

	/**
	 * Update user.
	 *
	 * @param user the user
	 */
	public void updateUser(User user);

	/**
	 * Delete user.
	 *
	 * @param user the user
	 */
	public void deleteUser(User user);

	/**
	 * List users.
	 *
	 * @return the list
	 */
	public List<User> listUsers();
	
	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User getUser(int id);

	/**
	 * Creates the component.
	 *
	 * @param component the component
	 * @return the component
	 */
	public Component createComponent(Component component);

	/**
	 * Update component.
	 *
	 * @param component the component
	 */
	public void updateComponent(Component component);

	/**
	 * Delete component.
	 *
	 * @param component the component
	 */
	public void deleteComponent(Component component);

	/**
	 * List components.
	 *
	 * @return the list
	 */
	public List<Component> listComponents();
	
	/**
	 * Gets the component.
	 *
	 * @param id the id
	 * @return the component
	 */
	public Component getComponent(int id);

	/**
	 * Gets the backlog.
	 *
	 * @return the backlog
	 */
	public Backlog getBacklog();
	
	/**
	 * Creates the story.
	 *
	 * @param story the story
	 * @return the story
	 */
	public Story createStory(Story story);
	
	/**
	 * Update story.
	 *
	 * @param story the story
	 */
	public void updateStory(Story story);
	
	/**
	 * Delete story.
	 *
	 * @param story the story
	 */
	public void deleteStory(Story story);
	
	/**
	 * Gets the story.
	 *
	 * @param id the id
	 * @return the story
	 */
	public Story getStory(int id);
	
	/**
	 * Gets the latests.
	 *
	 * @return the latests
	 */
	public List<Story> getLatests();
}
