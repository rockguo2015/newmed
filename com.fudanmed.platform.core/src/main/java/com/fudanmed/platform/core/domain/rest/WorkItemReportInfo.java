package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class WorkItemReportInfo extends BaseDataType {
  public WorkItemReportInfo() {
    super();
  }
  
  private Date reportDate;
  
  public Date getReportDate() {
    return this.reportDate;
  }
  
  public WorkItemReportInfo setReportDate(final Date reportDate) {
    this.reportDate = reportDate;
    return this;			
    
  }
  
  private Date reportTime;
  
  public Date getReportTime() {
    return this.reportTime;
  }
  
  public WorkItemReportInfo setReportTime(final Date reportTime) {
    this.reportTime = reportTime;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public WorkItemReportInfo setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  public static WorkItemReportInfo create() {
    return new WorkItemReportInfo();
    
    
  }
}
