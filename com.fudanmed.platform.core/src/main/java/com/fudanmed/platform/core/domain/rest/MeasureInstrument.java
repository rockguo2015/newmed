package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;

public class MeasureInstrument extends BaseDataType {
  public MeasureInstrument() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public MeasureInstrument setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public MeasureInstrument setLocation(final String location) {
    this.location = location;
    return this;			
    
  }
  
  private String lastValue;
  
  public String getLastValue() {
    return this.lastValue;
  }
  
  public MeasureInstrument setLastValue(final String lastValue) {
    this.lastValue = lastValue;
    return this;			
    
  }
  
  public static MeasureInstrument create() {
    return new MeasureInstrument();
    
    
  }
}
