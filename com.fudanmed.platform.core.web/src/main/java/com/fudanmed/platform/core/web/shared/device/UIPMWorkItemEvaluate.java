package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIPMWorkItemEvaluate implements IsSerializable {
  private String worker;
  
  public String getWorker() {
    return this.worker;
  }
  
  public void setWorker(final String worker) {
    this.worker = worker;
  }
  
  public final static String P_Worker = "worker";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,String> WorkerAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,String>(){
    				public String getValue(UIPMWorkItemEvaluate object){
    					return object.getWorker();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,String value){
    					object.setWorker(value);
    				}
    			};
  
  private Date notifyDate;
  
  public Date getNotifyDate() {
    return this.notifyDate;
  }
  
  public void setNotifyDate(final Date notifyDate) {
    this.notifyDate = notifyDate;
  }
  
  public final static String P_NotifyDate = "notifyDate";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Date> NotifyDateAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Date>(){
    				public java.util.Date getValue(UIPMWorkItemEvaluate object){
    					return object.getNotifyDate();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,java.util.Date value){
    					object.setNotifyDate(value);
    				}
    			};
  
  private Date arriveDate;
  
  public Date getArriveDate() {
    return this.arriveDate;
  }
  
  public void setArriveDate(final Date arriveDate) {
    this.arriveDate = arriveDate;
  }
  
  public final static String P_ArriveDate = "arriveDate";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Date> ArriveDateAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Date>(){
    				public java.util.Date getValue(UIPMWorkItemEvaluate object){
    					return object.getArriveDate();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,java.util.Date value){
    					object.setArriveDate(value);
    				}
    			};
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public void setPrice(final Double price) {
    this.price = price;
  }
  
  public final static String P_Price = "price";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Double> PriceAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Double>(){
    				public Double getValue(UIPMWorkItemEvaluate object){
    					return object.getPrice();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,Double value){
    					object.setPrice(value);
    				}
    			};
  
  private String materials;
  
  public String getMaterials() {
    return this.materials;
  }
  
  public void setMaterials(final String materials) {
    this.materials = materials;
  }
  
  public final static String P_Materials = "materials";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,String> MaterialsAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,String>(){
    				public String getValue(UIPMWorkItemEvaluate object){
    					return object.getMaterials();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,String value){
    					object.setMaterials(value);
    				}
    			};
  
  private Integer arrivalOnTime;
  
  public Integer getArrivalOnTime() {
    return this.arrivalOnTime;
  }
  
  public void setArrivalOnTime(final Integer arrivalOnTime) {
    this.arrivalOnTime = arrivalOnTime;
  }
  
  public final static String P_ArrivalOnTime = "arrivalOnTime";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer> ArrivalOnTimeAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer>(){
    				public Integer getValue(UIPMWorkItemEvaluate object){
    					return object.getArrivalOnTime();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,Integer value){
    					object.setArrivalOnTime(value);
    				}
    			};
  
  private Integer attitude;
  
  public Integer getAttitude() {
    return this.attitude;
  }
  
  public void setAttitude(final Integer attitude) {
    this.attitude = attitude;
  }
  
  public final static String P_Attitude = "attitude";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer> AttitudeAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer>(){
    				public Integer getValue(UIPMWorkItemEvaluate object){
    					return object.getAttitude();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,Integer value){
    					object.setAttitude(value);
    				}
    			};
  
  private Integer frequency;
  
  public Integer getFrequency() {
    return this.frequency;
  }
  
  public void setFrequency(final Integer frequency) {
    this.frequency = frequency;
  }
  
  public final static String P_Frequency = "frequency";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer> FrequencyAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer>(){
    				public Integer getValue(UIPMWorkItemEvaluate object){
    					return object.getFrequency();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,Integer value){
    					object.setFrequency(value);
    				}
    			};
  
  private Integer quality;
  
  public Integer getQuality() {
    return this.quality;
  }
  
  public void setQuality(final Integer quality) {
    this.quality = quality;
  }
  
  public final static String P_Quality = "quality";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer> QualityAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,Integer>(){
    				public Integer getValue(UIPMWorkItemEvaluate object){
    					return object.getQuality();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,Integer value){
    					object.setQuality(value);
    				}
    			};
  
  private String problemsRemains;
  
  public String getProblemsRemains() {
    return this.problemsRemains;
  }
  
  public void setProblemsRemains(final String problemsRemains) {
    this.problemsRemains = problemsRemains;
  }
  
  public final static String P_ProblemsRemains = "problemsRemains";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,String> ProblemsRemainsAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,String>(){
    				public String getValue(UIPMWorkItemEvaluate object){
    					return object.getProblemsRemains();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,String value){
    					object.setProblemsRemains(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIPMWorkItemEvaluate,String> CommentAccessor = new IObjectFieldAccessor<UIPMWorkItemEvaluate,String>(){
    				public String getValue(UIPMWorkItemEvaluate object){
    					return object.getComment();
    				}
    				public void setValue(UIPMWorkItemEvaluate object,String value){
    					object.setComment(value);
    				}
    			};
}
