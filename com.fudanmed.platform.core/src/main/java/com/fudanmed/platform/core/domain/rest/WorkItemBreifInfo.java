package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class WorkItemBreifInfo extends BaseDataType {
  public WorkItemBreifInfo() {
    super();
  }
  
  private Long id;
  
  public Long getId() {
    return this.id;
  }
  
  public WorkItemBreifInfo setId(final Long id) {
    this.id = id;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public WorkItemBreifInfo setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public WorkItemBreifInfo setTime(final Date time) {
    this.time = time;
    return this;			
    
  }
  
  public static WorkItemBreifInfo create() {
    return new WorkItemBreifInfo();
    
    
  }
}
