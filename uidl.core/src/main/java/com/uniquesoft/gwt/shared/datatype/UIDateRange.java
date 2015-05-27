package com.uniquesoft.gwt.shared.datatype;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UIDateRange implements IsSerializable{
	private Date from;
	private Date to;
	public UIDateRange(){
		
	}
	public UIDateRange(Date from, Date to) {
		super();
		this.from = from;
		this.to = to;
	}

	public void setFrom(Date from) {
		this.from = from;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}	
}
