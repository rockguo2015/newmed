package com.lanmon.business.shared.customer;

public enum GWTRole {
  admin,

  phoneSales,

  onsiteSales,

  manager,

  test;
  
  public String toString() {
    switch(this){
    case admin:
    	return "管理员";
    case manager:
    	return "商务主管";
    case onsiteSales:
    	return "上门商务";
    case phoneSales:
    	return "电话销售1";
    	default:
    		return "";
    }
  }
}
