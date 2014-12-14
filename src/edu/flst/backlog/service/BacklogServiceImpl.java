/*
 * 
 */
package edu.flst.backlog.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import edu.flst.backlog.bo.Backlog;
import edu.flst.backlog.bo.Component;
import edu.flst.backlog.bo.Job;
import edu.flst.backlog.bo.Status;
import edu.flst.backlog.bo.Story;
import edu.flst.backlog.bo.User;

// TODO: Auto-generated Javadoc
/**
 * The Class BacklogServiceImpl.
 */
@org.springframework.stereotype.Component
public class BacklogServiceImpl implements BacklogService {
	
	/** The users. */
	private List<User> users = new ArrayList<User>();
	
	/** The components. */
	private List<Component> components = new ArrayList<Component>();
	
	/** The backlog. */
	private Backlog backlog = new Backlog();
	
	/** The id user. */
	private static int idUser = 0;
	
	/** The id component. */
	private static int idComponent = 0;
	
	/** The id story. */
	private static int idStory = 0;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	protected void init() {		
		User user = new User();
		user.setFirstName("firstName1");
		user.setLastName("lastName1");
		user.setJob(Job.ANALYST);
		this.createUser(user);
		
		User user1 = new User();
		user1.setFirstName("firstName2");
		user1.setLastName("lastName2");
		user1.setJob(Job.DEVELOPPER);
		this.createUser(user1);
		
		User user2 = new User();
		user2.setFirstName("firstName3");
		user2.setLastName("lastName3");
		user2.setJob(Job.PROJECT_MANAGER);
		this.createUser(user2);
		
		User user3 = new User();
		user3.setFirstName("firstName4");
		user3.setLastName("lastName4");
		user3.setJob(Job.ANALYST);
		this.createUser(user3);
		
		Component component = new Component();
		component.setLabel("label1");
		component.setDescription("description1");
		component.setOwner(user);
		this.createComponent(component);
		
		Component component1 = new Component();
		component1.setLabel("label2");
		component1.setDescription("description2");
		component1.setOwner(user1);
		this.createComponent(component1);
		
		Component component2 = new Component();
		component2.setLabel("label3");
		component2.setDescription("description3");
		component2.setOwner(user2);
		this.createComponent(component2);
		
		Component component3 = new Component();
		component3.setLabel("label4");
		component3.setDescription("description4");
		component3.setOwner(user3);
		this.createComponent(component3);
		
		Story story = new Story();
		story.setLabel("label1");
		story.setComment("comment1");
		story.setComponent(component);
		story.setStatus(Status.DONE);
		story.setUser(user);
		this.createStory(story);
		
	}
	
	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#createComponent(edu.flst.backlog.bo.Component)
	 */
	@Override
	public Component createComponent(Component component) {
		component.setId(idComponent++);
		components.add(component);
		return component;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#createUser(edu.flst.backlog.bo.User)
	 */
	@Override
	public User createUser(User user) {
		user.setId(idUser++);
		users.add(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#deleteComponent(edu.flst.backlog.bo.Component)
	 */
	@Override
	public void deleteComponent(Component component) {
		components.remove(component);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#deleteUser(edu.flst.backlog.bo.User)
	 */
	@Override
	public void deleteUser(User user) {
		users.remove(user);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#getBacklog()
	 */
	@Override
	public Backlog getBacklog() {
		return backlog;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#updateComponent(edu.flst.backlog.bo.Component)
	 */
	@Override
	public void updateComponent(Component component) {
		components.remove(component);
		components.add(component);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#updateUser(edu.flst.backlog.bo.User)
	 */
	@Override
	public void updateUser(User user) {
		users.remove(user);
		users.add(user);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#listComponents()
	 */
	@Override
	public List<Component> listComponents() {
		Collections.sort(components);
		return components;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#listUsers()
	 */
	@Override
	public List<User> listUsers() {
		Collections.sort(users);
		return users;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#getUser(int)
	 */
	@Override
	public User getUser(int id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#getComponent(int)
	 */
	@Override
	public Component getComponent(int id) {
		for(Component component : components){
			if(component.getId() == id){
				return component;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#createStory(edu.flst.backlog.bo.Story)
	 */
	@Override
	public Story createStory(Story story) {
		story.setId(idStory++);
		story.setCreatedDate(new Date());
		story.setModifiedDate(new Date());
		backlog.addStory(story);
		return story;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#getLatests()
	 */
	@Override
	public List<Story> getLatests() {
		List<Story> stories = backlog.getStories();
		Collections.sort(stories, new LatestStoryComparator());
		//Collections.reverse(stories);
		if(stories.size() > 3){
			return stories.subList(0, 3);			
		}
		
		return stories;
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#updateStory(edu.flst.backlog.bo.Story)
	 */
	@Override
	public void updateStory(Story story) {
		story.setModifiedDate(new Date());
		backlog.removeStory(story);
		backlog.addStory(story);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#deleteStory(edu.flst.backlog.bo.Story)
	 */
	@Override
	public void deleteStory(Story story) {
		backlog.getStories().remove(story);
	}

	/* (non-Javadoc)
	 * @see edu.flst.backlog.service.BacklogService#getStory(int)
	 */
	@Override
	public Story getStory(int id) {
		for(Story story : backlog.getStories()){
			if(story.getId() == id){
				return story;
			}
		}
		
		return null;
	}

}
