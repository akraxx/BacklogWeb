/*
 * 
 */
package edu.flst.backlog.web;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.flst.backlog.bo.Story;
import edu.flst.backlog.form.StoryForm;
import edu.flst.backlog.service.BacklogService;

// TODO: Auto-generated Javadoc
/**
 * The Class StoryController.
 */
@Controller
@RequestMapping(value="/story")
public class StoryController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UserController.class.getName());
	
	/** The backlog service. */
	@Autowired private BacklogService backlogService;
	
	/**
	 * Load details form.
	 *
	 * @param storyForm the story form
	 * @return the model and view
	 */
	private ModelAndView loadDetailsForm(StoryForm storyForm) {
		ModelAndView mNv = new ModelAndView("story/detail");
		mNv.addObject("users", backlogService.listUsers());
		mNv.addObject("components", backlogService.listComponents());
		mNv.addObject("storyForm", storyForm);
		return mNv;
	}
	
	/**
	 * Load details form.
	 *
	 * @param objects the objects
	 * @return the model and view
	 */
	private ModelAndView loadDetailsForm(Map<String, Object> objects) {
		ModelAndView mNv = new ModelAndView("story/detail");
		mNv.addObject("users", backlogService.listUsers());
		mNv.addObject("components", backlogService.listComponents());
		mNv.addAllObjects(objects);
		return mNv;
	}
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(BacklogService.DEFAULT_DATE_FORMAT, false));
	}
	
	/**
	 * List story.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView listStory(){
		LOG.info("Print list of stories");
		ModelAndView mNv = new ModelAndView("story/list");
		mNv.addObject("stories", backlogService.getBacklog().getStories());
		return mNv;
	}
	
	/**
	 * Lastest story.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/latest.do", method=RequestMethod.GET)
	public ModelAndView lastestStory(){
		LOG.info("Get the latests stories");
		ModelAndView mNv = new ModelAndView("story/latests");
		mNv.addObject("stories", backlogService.getLatests());
		return mNv;
	}
	
	/**
	 * Creates the user.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public ModelAndView createUser(){
		LOG.info("Create a new story");
		StoryForm storyForm = new StoryForm();
		storyForm.setAction("/save.do");
		return loadDetailsForm(storyForm);
	}
	
	/**
	 * Save user.
	 *
	 * @param storyForm the story form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/save.do", method=RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("storyForm") StoryForm storyForm, BindingResult results) {
		LOG.info("Try to save the story");
		if(results.hasErrors()) {
			LOG.warning("Unable to add a new story, there are some errors");
			return loadDetailsForm(results.getModel());
		}
		else {
			LOG.info("Save the story in the backlog");
			Story story = storyForm.getObject();
			story.setUser(backlogService.getUser(storyForm.getIdUser()));
			story.setComponent(backlogService.getComponent(storyForm.getIdComponent()));
			backlogService.createStory(story);
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Update user.
	 *
	 * @param storyForm the story form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("storyForm") StoryForm storyForm, BindingResult results) {
		LOG.info("Try to update the story");
		if(results.hasErrors()) {
			LOG.warning("Unable to update the story, there are some errors");
			return loadDetailsForm(results.getModel());
		}
		else {
			LOG.info("Save the story in the backlog");
			Story story = storyForm.getObject();
			story.setUser(backlogService.getUser(storyForm.getIdUser()));
			story.setComponent(backlogService.getComponent(storyForm.getIdComponent()));
			backlogService.updateStory(story);
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Edits the story.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/edit.do", method=RequestMethod.GET)
	public ModelAndView editStory(@PathVariable Integer id){
		LOG.info("Edit the story " + id);
		StoryForm storyForm = new StoryForm(backlogService.getStory(id));
		storyForm.setAction("/update.do");
		return loadDetailsForm(storyForm);
	}
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id){
		LOG.info("Delete the story " + id);
		backlogService.deleteStory(backlogService.getStory(id));
		return new ModelAndView(new RedirectView("/backlog/show.do", true));
	}
}
