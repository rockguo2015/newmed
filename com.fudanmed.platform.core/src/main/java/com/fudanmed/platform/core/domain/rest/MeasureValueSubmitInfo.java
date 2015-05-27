package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class MeasureValueSubmitInfo extends BaseDataType {
  public MeasureValueSubmitInfo() {
    super();
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public MeasureValueSubmitInfo setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String value;
  
  public String getValue() {
    return this.value;
  }
  
  public MeasureValueSubmitInfo setValue(final String value) {
    this.value = value;
    return this;			
    
  }
  
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public MeasureValueSubmitInfo setUserid(final String userid) {
    this.userid = userid;
    return this;			
    
  }
  
  public static MeasureValueSubmitInfo create() {
    return new MeasureValueSubmitInfo();
    
    
  }
}
