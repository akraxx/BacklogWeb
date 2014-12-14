/*
 * 
 */
package edu.flst.backlog.service;

import java.util.Comparator;

import edu.flst.backlog.bo.Story;

// TODO: Auto-generated Javadoc
/**
 * The Class LatestStoryComparator.
 */
public class LatestStoryComparator implements Comparator<Story>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Story arg0, Story arg1) {
		return arg1.getModifiedDate().compareTo(arg0.getModifiedDate());
	}

}
