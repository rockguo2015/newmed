package com.fudanmed.platform.core.domain.rest;

import com.fudanmed.platform.core.domain.rest.WorkItemReportInfo;
import edu.fudan.mylang.pf.BaseDataType;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;

public class WorkItemFinishInfo extends BaseDataType {
  public WorkItemFinishInfo() {
    super();
  }
  
  private String deviceNumber;
  
  public String getDeviceNumber() {
    return this.deviceNumber;
  }
  
  public WorkItemFinishInfo setDeviceNumber(final String deviceNumber) {
    this.deviceNumber = deviceNumber;
    return this;			
    
  }
  
  private String photos;
  
  public String getPhotos() {
    return this.photos;
  }
  
  public WorkItemFinishInfo setPhotos(final String photos) {
    this.photos = photos;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "reportDate", column = @Column(name = "info_reportDate") ), @AttributeOverride(name = "reportTime", column = @Column(name = "info_reportTime") ), @AttributeOverride(name = "description", column = @Column(name = "info_description") ), @AttributeOverride(name = "workaround", column = @Column(name = "info_workaround") ) } )
  @AssociationOverrides(value = { } )
  private WorkItemReportInfo info = com.fudanmed.platform.core.domain.rest.WorkItemReportInfo.create();
  
  public WorkItemReportInfo getInfo() {
    return this.info;
  }
  
  public WorkItemFinishInfo setInfo(final WorkItemReportInfo info) {
    this.info = info;
    return this;			
    
  }
  
  public static WorkItemFinishInfo create() {
    return new WorkItemFinishInfo();
    
    
  }
}
