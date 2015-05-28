package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIRepairEvaluate extends GWTEntity {
  private UIEvaluateState evaluateState;
  
  public UIEvaluateState getEvaluateState() {
    return this.evaluateState;
  }
  
  public void setEvaluateState(final UIEvaluateState evaluateState) {
    this.evaluateState = evaluateState;
  }
  
  public final static String P_EvaluateState = "evaluateState";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,UIEvaluateState> EvaluateStateAccessor = new IObjectFieldAccessor<UIRepairEvaluate,UIEvaluateState>(){
    				public com.fudanmed.platform.core.web.shared.project.UIEvaluateState getValue(UIRepairEvaluate object){
    					return object.getEvaluateState();
    				}
    				public void setValue(UIRepairEvaluate object,com.fudanmed.platform.core.web.shared.project.UIEvaluateState value){
    					object.setEvaluateState(value);
    				}
    			};
  
  private Integer arrivalTimeValue;
  
  public Integer getArrivalTimeValue() {
    return this.arrivalTimeValue;
  }
  
  public void setArrivalTimeValue(final Integer arrivalTimeValue) {
    this.arrivalTimeValue = arrivalTimeValue;
  }
  
  public final static String P_ArrivalTimeValue = "arrivalTimeValue";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,Integer> ArrivalTimeValueAccessor = new IObjectFieldAccessor<UIRepairEvaluate,Integer>(){
    				public Integer getValue(UIRepairEvaluate object){
    					return object.getArrivalTimeValue();
    				}
    				public void setValue(UIRepairEvaluate object,Integer value){
    					object.setArrivalTimeValue(value);
    				}
    			};
  
  private Integer serviceAttitudeValue;
  
  public Integer getServiceAttitudeValue() {
    return this.serviceAttitudeValue;
  }
  
  public void setServiceAttitudeValue(final Integer serviceAttitudeValue) {
    this.serviceAttitudeValue = serviceAttitudeValue;
  }
  
  public final static String P_ServiceAttitudeValue = "serviceAttitudeValue";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,Integer> ServiceAttitudeValueAccessor = new IObjectFieldAccessor<UIRepairEvaluate,Integer>(){
    				public Integer getValue(UIRepairEvaluate object){
    					return object.getServiceAttitudeValue();
    				}
    				public void setValue(UIRepairEvaluate object,Integer value){
    					object.setServiceAttitudeValue(value);
    				}
    			};
  
  private Integer frequencyProblemValue;
  
  public Integer getFrequencyProblemValue() {
    return this.frequencyProblemValue;
  }
  
  public void setFrequencyProblemValue(final Integer frequencyProblemValue) {
    this.frequencyProblemValue = frequencyProblemValue;
  }
  
  public final static String P_FrequencyProblemValue = "frequencyProblemValue";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,Integer> FrequencyProblemValueAccessor = new IObjectFieldAccessor<UIRepairEvaluate,Integer>(){
    				public Integer getValue(UIRepairEvaluate object){
    					return object.getFrequencyProblemValue();
    				}
    				public void setValue(UIRepairEvaluate object,Integer value){
    					object.setFrequencyProblemValue(value);
    				}
    			};
  
  private Integer repairQualityValue;
  
  public Integer getRepairQualityValue() {
    return this.repairQualityValue;
  }
  
  public void setRepairQualityValue(final Integer repairQualityValue) {
    this.repairQualityValue = repairQualityValue;
  }
  
  public final static String P_RepairQualityValue = "repairQualityValue";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,Integer> RepairQualityValueAccessor = new IObjectFieldAccessor<UIRepairEvaluate,Integer>(){
    				public Integer getValue(UIRepairEvaluate object){
    					return object.getRepairQualityValue();
    				}
    				public void setValue(UIRepairEvaluate object,Integer value){
    					object.setRepairQualityValue(value);
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
  
  public static IObjectFieldAccessor<UIRepairEvaluate,String> CommentAccessor = new IObjectFieldAccessor<UIRepairEvaluate,String>(){
    				public String getValue(UIRepairEvaluate object){
    					return object.getComment();
    				}
    				public void setValue(UIRepairEvaluate object,String value){
    					object.setComment(value);
    				}
    			};
  
  private RCEmployeeProxy evaluator;
  
  public RCEmployeeProxy getEvaluator() {
    return this.evaluator;
  }
  
  public void setEvaluator(final RCEmployeeProxy evaluator) {
    this.evaluator = evaluator;
  }
  
  public final static String P_Evaluator = "evaluator";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,RCEmployeeProxy> EvaluatorAccessor = new IObjectFieldAccessor<UIRepairEvaluate,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIRepairEvaluate object){
    					return object.getEvaluator();
    				}
    				public void setValue(UIRepairEvaluate object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setEvaluator(value);
    				}
    			};
  
  private Date evaluateDate;
  
  public Date getEvaluateDate() {
    return this.evaluateDate;
  }
  
  public void setEvaluateDate(final Date evaluateDate) {
    this.evaluateDate = evaluateDate;
  }
  
  public final static String P_EvaluateDate = "evaluateDate";
  
  public static IObjectFieldAccessor<UIRepairEvaluate,Date> EvaluateDateAccessor = new IObjectFieldAccessor<UIRepairEvaluate,Date>(){
    				public java.util.Date getValue(UIRepairEvaluate object){
    					return object.getEvaluateDate();
    				}
    				public void setValue(UIRepairEvaluate object,java.util.Date value){
    					object.setEvaluateDate(value);
    				}
    			};
  
  public RCRepairEvaluateProxy toProxy() {
    return (RCRepairEvaluateProxy)super.toProxy();
    
  }
}
