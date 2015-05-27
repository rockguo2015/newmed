package com.lanmon.business.shared.customer;

public enum GWTCustomerStatus {
  normal,

  tracking,

  intended,

  onsite,

  contracted,

  decontracted;
  
  public String toString() {
    switch(this){
    case contracted:
    	return "签约客户";
    case intended:
    	return "意向客户";
    case onsite:
    	return "上门客户";
    case tracking:
    	return "潜在客户";
    case normal:
    	return "一般客户";
    case decontracted:
    	return "解约用户";
    	default:
    		return "";
    }
  }
}
