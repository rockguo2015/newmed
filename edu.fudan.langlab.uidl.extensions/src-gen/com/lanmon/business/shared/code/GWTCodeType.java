package com.lanmon.business.shared.code;

public enum GWTCodeType {
  Domain,

  Scale,

  Property,

  Region,

  Contact;
  
  public String toString() {
    switch(this){
    case Domain:
    	return "所属行业";
    case Property:
    	return "企业性质";
    case Scale:
    	return "企业规模";
    case Region:
    	return "区域";
    case Contact:
    	return "联系人类型";
    	default:
    		return "";
    }
  }
}
