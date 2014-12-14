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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.flst.backlog.bo.Backlog;
import edu.flst.backlog.form.BacklogForm;
import edu.flst.backlog.service.BacklogService;

// TODO: Auto-generated Javadoc
/**
 * The Class BacklogController.
 */
@Controller
@RequestMapping(value="/backlog/")
public class BacklogController {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(BacklogController.class.getName());
	
	/** The backlog service. */
	@Autowired private BacklogService backlogService;
	
	/**
	 * List backlog.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/show.do", method=RequestMethod.GET)
	public ModelAndView showBacklog(){
		LOG.info("Print the backlog");
		ModelAndView mNv = new ModelAndView("backlog/show");
		mNv.addObject("backlog", backlogService.getBacklog());
		mNv.addObject("stories", backlogService.getBacklog().getStories());
		mNv.addObject("users", backlogService.listUsers());
		mNv.addObject("components", backlogService.listComponents());
		return mNv;
	}
	
	/**
	 * Update backlog.
	 *
	 * @param backlogForm the backlog form
	 * @param results the results
	 * @return the model and view
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView updateBacklog(@Valid @ModelAttribute("backlogForm") BacklogForm backlogForm, BindingResult results) {
		LOG.info("Try to update the backlog");
		if(results.hasErrors()) {
			LOG.warning("Unable to update the backlog, there are some errors");
			ModelAndView mNv = new ModelAndView("backlog/edit");
			mNv.addObject("users", backlogService.listUsers());
			mNv.addAllObjects(results.getModel());
			return mNv;
		}
		else {
			LOG.info("Save the backlog in the backlog");
			Backlog backlog = backlogService.getBacklog();
			backlog.setDescription(backlogForm.getDescription());
			backlog.setOwner(backlogService.getUser(backlogForm.getIdOwner()));
			return new ModelAndView(new RedirectView("/backlog/show.do", true));
		}
	}
	
	/**
	 * Edits the backlog.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/edit.do", method=RequestMethod.GET)
	public ModelAndView editBacklog(){
		LOG.info("Edit the backlog");
		ModelAndView mNv = new ModelAndView("backlog/edit");
		mNv.addObject("users", backlogService.listUsers());
		mNv.addObject("backlogForm", new BacklogForm(backlogService.getBacklog()));
		return mNv;
	}
}