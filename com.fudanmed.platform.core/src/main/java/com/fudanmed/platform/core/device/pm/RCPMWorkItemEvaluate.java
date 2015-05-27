package com.fudanmed.platform.core.device.pm;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class RCPMWorkItemEvaluate extends BaseDataType {
  public RCPMWorkItemEvaluate() {
    super();
  }
  
  private String worker;
  
  public String getWorker() {
    return this.worker;
  }
  
  public RCPMWorkItemEvaluate setWorker(final String worker) {
    this.worker = worker;
    return this;			
    
  }
  
  private Date notifyDate;
  
  public Date getNotifyDate() {
    return this.notifyDate;
  }
  
  public RCPMWorkItemEvaluate setNotifyDate(final Date notifyDate) {
    this.notifyDate = notifyDate;
    return this;			
    
  }
  
  private Date arriveDate;
  
  public Date getArriveDate() {
    return this.arriveDate;
  }
  
  public RCPMWorkItemEvaluate setArriveDate(final Date arriveDate) {
    this.arriveDate = arriveDate;
    return this;			
    
  }
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public RCPMWorkItemEvaluate setPrice(final Double price) {
    this.price = price;
    return this;			
    
  }
  
  private String materials;
  
  public String getMaterials() {
    return this.materials;
  }
  
  public RCPMWorkItemEvaluate setMaterials(final String materials) {
    this.materials = materials;
    return this;			
    
  }
  
  private Integer arrivalOnTime;
  
  public Integer getArrivalOnTime() {
    return this.arrivalOnTime;
  }
  
  public RCPMWorkItemEvaluate setArrivalOnTime(final Integer arrivalOnTime) {
    this.arrivalOnTime = arrivalOnTime;
    return this;			
    
  }
  
  private Integer attitude;
  
  public Integer getAttitude() {
    return this.attitude;
  }
  
  public RCPMWorkItemEvaluate setAttitude(final Integer attitude) {
    this.attitude = attitude;
    return this;			
    
  }
  
  private Integer frequency;
  
  public Integer getFrequency() {
    return this.frequency;
  }
  
  public RCPMWorkItemEvaluate setFrequency(final Integer frequency) {
    this.frequency = frequency;
    return this;			
    
  }
  
  private Integer quality;
  
  public Integer getQuality() {
    return this.quality;
  }
  
  public RCPMWorkItemEvaluate setQuality(final Integer quality) {
    this.quality = quality;
    return this;			
    
  }
  
  private String problemsRemains;
  
  public String getProblemsRemains() {
    return this.problemsRemains;
  }
  
  public RCPMWorkItemEvaluate setProblemsRemains(final String problemsRemains) {
    this.problemsRemains = problemsRemains;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCPMWorkItemEvaluate setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  public static RCPMWorkItemEvaluate create() {
    return new RCPMWorkItemEvaluate();
    
    
  }
}
