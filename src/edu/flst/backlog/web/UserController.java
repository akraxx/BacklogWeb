/*
 * 
 */
package edu.flst.backlog.web;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.flst.backlog.form.UserForm;
import edu.flst.backlog.service.BacklogService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(UserController.class.getName());
	
	/** The backlog service. */
	@Autowired private BacklogService backlogService;
	
	/**
	 * List user.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView listUser(){
		LOG.info("Print list of users");
		ModelAndView mNv = new ModelAndView("user/list");
		mNv.addObject("users", backlogService.listUsers());
		return mNv;
	}
	
	/**
	 * Creates the user.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public ModelAndView createUser(){
		LOG.info("Create a new user");
		ModelAndView mNv = new ModelAndView("user/detail");
		UserForm userForm = new UserForm();
		userForm.setAction("/save.do");
		mNv.addObject("userForm", userForm);
		return mNv;
	}
	
	/**
	 * Save user.
	 *
	 * @param userForm the user form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/save.do", method=RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult results) {
		LOG.info("Try to save the user");
		if(results.hasErrors()) {
			LOG.warning("Unable to add a new user, there are some errors");
			ModelAndView mNv = new ModelAndView("user/detail");
			mNv.addAllObjects(results.getModel());
			return mNv;
		}
		else {
			LOG.info("Save the user in the backlog");
			backlogService.createUser(userForm.getObject());
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Update user.
	 *
	 * @param userForm the user form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult results) {
		LOG.info("Try to update the user");
		if(results.hasErrors()) {
			LOG.warning("Unable to update the user, there are some errors");
			ModelAndView mNv = new ModelAndView("user/detail");
			mNv.addAllObjects(results.getModel());
			return mNv;
		}
		else {
			LOG.info("Save the user in the backlog");
			backlogService.updateUser(userForm.getObject());
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Edits the user.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/edit.do", method=RequestMethod.GET)
	public ModelAndView editUser(@PathVariable Integer id) {
		LOG.info("Edit the user " + id);
		ModelAndView mNv = new ModelAndView("user/detail");
		UserForm userForm = new UserForm(backlogService.getUser(id));
		userForm.setAction("/update.do");
		mNv.addObject("userForm", userForm);
		return mNv;
	}
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id){
		LOG.info("Delete the user " + id);
		backlogService.deleteUser(backlogService.getUser(id));
		return new ModelAndView(new RedirectView("/backlog/show.do", true));
	}
}
