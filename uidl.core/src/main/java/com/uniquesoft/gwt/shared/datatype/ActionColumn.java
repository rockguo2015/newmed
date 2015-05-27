package com.uniquesoft.gwt.shared.datatype;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ActionColumn implements IsSerializable {

	public ActionColumn(String title){
		this.title = title;
	}
	
	public ActionColumn(){
		
	}
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
