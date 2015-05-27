/**
 * 
 */
package edu.fudan.mylang.pf.query;
import java.util.Collection;

import edu.fudan.mylang.pf.query.PagedCriteriaDecroater.ISelecter;


public class ExcludeSelecter<T> implements ISelecter<T> {
	Collection<T> excluded = null;

	public ExcludeSelecter(Collection<T> excluded) {
		this.excluded = excluded;
	}

	public boolean select(T candidate) {
		return !excluded.contains(candidate);
	}

}