package com.uniquesoft.uidl.validation.rules;

import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.uidl.validation.IRule;

/**
 *First make sure the value is not null, then if it's 
 *a string type ,make sure its size is not zero, at last ,
 *if it's a Iterable type ,check its size is not zero.
 *
 */
public class Required implements IRule {

	Object value;

	public Required(Object value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#checkValid()
	 * Check the value , make sure it's not null or empty
	 */
	@Override
	public Boolean checkValid() {
		if (value == null)
			return false;
		else if (value instanceof String) {
			return ((String) value).trim().length() != 0;
		}else if(value instanceof Iterable){
			return Iterables.size(((Iterable<?>)value)) != 0;
		}else if(value instanceof File){
			return !StringExtensions.isNullOrEmpty(((File)value).getFullPathName());
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.validation.IRule#getMessage()
	 * give the error message if the value is null or empty.
	 */
	@Override
	public String getMessage() {
		return "该项目必须输入";
	}

}
