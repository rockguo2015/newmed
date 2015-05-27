package com.lanmon.business.shared.message;

public enum TriggerType {
  OneTime,

  Periodic,

  ContractDate,

  OutSourceDate;
  
  public String toString() {
    switch(this){
    case ContractDate:
    	return "合同期限";
    case OneTime:
    	return "单次提醒";
    case Periodic:
    	return "周期提醒";
    case OutSourceDate:
    	return "外包到期";
    	default:
    		return "";
    }
  }
}
