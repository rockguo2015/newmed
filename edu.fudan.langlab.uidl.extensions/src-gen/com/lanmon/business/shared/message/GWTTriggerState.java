package com.lanmon.business.shared.message;

public enum GWTTriggerState {
  Waiting,

  Triggled,

  Stopped;
  
  public String toString() {
    switch(this){
    case Waiting:
    	return "待触发";
    case Triggled:
    	return "已触发";
    case Stopped:
    	return "已终止";
    	default:
    		return "";
    }
  }
}
