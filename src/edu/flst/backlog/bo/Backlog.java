/*
 * 
 */
package edu.flst.backlog.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;


// TODO: Auto-generated Javadoc
/**
 * The Class Backlog.
 */
public class Backlog implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1711180866003111383L;

	/** The stories. */
	private List<Story> stories = new ArrayList<Story>();
	
	/** The description. */
	private String description;
	
	/** The owner. */
	private User owner;

	/**
	 * Sets the stories.
	 *
	 * @param stories the new stories
	 */
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	/**
	 * Gets the stories.
	 *
	 * @return the stories
	 */
	public List<Story> getStories() {
		Collections.sort(stories);
		return stories;
	}

	/**
	 * Adds the story.
	 *
	 * @param story the story
	 */
	public void addStory(Story story){
		stories.add(story);
	}

	/**
	 * Removes the story.
	 *
	 * @param story the story
	 */
	public void removeStory(Story story){
		stories.remove(story);
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
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}


	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
