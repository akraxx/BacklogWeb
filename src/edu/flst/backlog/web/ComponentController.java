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

import edu.flst.backlog.bo.Component;
import edu.flst.backlog.form.ComponentForm;
import edu.flst.backlog.service.BacklogService;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentController.
 */
@Controller
@RequestMapping(value="/component")
public class ComponentController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ComponentController.class.getName());
	
	/** The backlog service. */
	@Autowired private BacklogService backlogService;
	
	/**
	 * List component.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView listComponent(){
		LOG.info("Print list of components");
		ModelAndView mNv = new ModelAndView("component/list");
		mNv.addObject("components", backlogService.listComponents());
		return mNv;
	}
	
	/**
	 * Creates the component.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public ModelAndView createComponent(){
		LOG.info("Create a new story");
		ModelAndView mNv = new ModelAndView("component/detail");
		mNv.addObject("users", backlogService.listUsers());
		ComponentForm componentForm = new ComponentForm();
		componentForm.setAction("/save.do");
		mNv.addObject("componentForm", componentForm);
		return mNv;
	}
	
	/**
	 * Save component.
	 *
	 * @param componentForm the component form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/save.do", method=RequestMethod.POST)
	public ModelAndView saveComponent(@Valid @ModelAttribute("componentForm") ComponentForm componentForm, BindingResult results) {
		LOG.info("Try to save the component");
		if(results.hasErrors()) {
			LOG.warning("Unable to add a new component, there are some errors");
			ModelAndView mNv = new ModelAndView("component/detail");
			mNv.addObject("users", backlogService.listUsers());
			mNv.addAllObjects(results.getModel());
			return mNv;
		}
		else {
			LOG.info("Save the component in the backlog");
			Component component = componentForm.getObject();
			component.setOwner(backlogService.getUser(componentForm.getIdOwner()));
			backlogService.createComponent(component);
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Update component.
	 *
	 * @param componentForm the component form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView updateComponent(@Valid @ModelAttribute("componentForm") ComponentForm componentForm, BindingResult results) {
		LOG.info("Try to update the component");
		if(results.hasErrors()) {
			LOG.warning("Unable to update the component, there are some errors");
			ModelAndView mNv = new ModelAndView("component/detail");
			mNv.addObject("users", backlogService.listUsers());
			mNv.addAllObjects(results.getModel());
			return mNv;
		}
		else {
			LOG.info("Save the component in the backlog");
			Component component = componentForm.getObject();
			component.setOwner(backlogService.getUser(componentForm.getIdOwner()));
			backlogService.updateComponent(component);
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Edits the component.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/edit.do", method=RequestMethod.GET)
	public ModelAndView editComponent(@PathVariable Integer id){
		LOG.info("Edit the component " + id);
		ModelAndView mNv = new ModelAndView("component/detail");
		mNv.addObject("users", backlogService.listUsers());
		ComponentForm componentForm = new ComponentForm(backlogService.getComponent(id));
		componentForm.setAction("/update.do");
		mNv.addObject("componentForm", componentForm);
		return mNv;
	}
	
	/**
	 * Delete component.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value="/{id}/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteComponent(@PathVariable Integer id){
		LOG.info("Delete the user " + id);
		backlogService.deleteComponent(backlogService.getComponent(id));
		return new ModelAndView(new RedirectView("/backlog/show.do", true));
	}
}
