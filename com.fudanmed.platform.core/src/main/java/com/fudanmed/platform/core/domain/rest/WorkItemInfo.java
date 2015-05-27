package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class WorkItemInfo extends BaseDataType {
  public WorkItemInfo() {
    super();
  }
  
  private Long id;
  
  public Long getId() {
    return this.id;
  }
  
  public WorkItemInfo setId(final Long id) {
    this.id = id;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public WorkItemInfo setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public WorkItemInfo setReportSid(final String reportSid) {
    this.reportSid = reportSid;
    return this;			
    
  }
  
  private String status;
  
  public String getStatus() {
    return this.status;
  }
  
  public WorkItemInfo setStatus(final String status) {
    this.status = status;
    return this;			
    
  }
  
  private Date reportTime;
  
  public Date getReportTime() {
    return this.reportTime;
  }
  
  public WorkItemInfo setReportTime(final Date reportTime) {
    this.reportTime = reportTime;
    return this;			
    
  }
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public WorkItemInfo setTime(final Date time) {
    this.time = time;
    return this;			
    
  }
  
  private String workers;
  
  public String getWorkers() {
    return this.workers;
  }
  
  public WorkItemInfo setWorkers(final String workers) {
    this.workers = workers;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public WorkItemInfo setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public WorkItemInfo setLocation(final String location) {
    this.location = location;
    return this;			
    
  }
  
  private String organization;
  
  public String getOrganization() {
    return this.organization;
  }
  
  public WorkItemInfo setOrganization(final String organization) {
    this.organization = organization;
    return this;			
    
  }
  
  private String reporter;
  
  public String getReporter() {
    return this.reporter;
  }
  
  public WorkItemInfo setReporter(final String reporter) {
    this.reporter = reporter;
    return this;			
    
  }
  
  private String reporterPhone;
  
  public String getReporterPhone() {
    return this.reporterPhone;
  }
  
  public WorkItemInfo setReporterPhone(final String reporterPhone) {
    this.reporterPhone = reporterPhone;
    return this;			
    
  }
  
  private String emergencyType;
  
  public String getEmergencyType() {
    return this.emergencyType;
  }
  
  public WorkItemInfo setEmergencyType(final String emergencyType) {
    this.emergencyType = emergencyType;
    return this;			
    
  }
  
  public static WorkItemInfo create() {
    return new WorkItemInfo();
    
    
  }
}
