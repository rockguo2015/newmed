package com.uniquesoft.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface IGWTEntity extends IsSerializable {
	public Long getId();

	public String getClazzName();
	
	public Object toProxy();	

}
