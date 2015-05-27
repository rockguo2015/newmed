package com.lanmon.business.shared.message;

public enum GWTContractDateTriggerType {
  OnStart,

  OnFinish;
  
  public String toString() {
    switch(this){
    case OnStart:
    	return "合同开始提醒";
    case OnFinish:
    	return "合同结束提醒";
    	default:
    		return "";
    }
  }
}
