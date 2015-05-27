package com.lanmon.business.shared.event;

public enum GWTEventType {
  PhoneCall,

  Visit,

  Meeting,

  Normal;
  
  public String toString() {
    switch(this){
    case Meeting:
    	return "会议记录";
    case PhoneCall:
    	return "电话记录";
    case Visit:
    	return "上门记录";
    case Normal:
    	return "普通记录";
    	default:
    		return "";
    }
  }
}
