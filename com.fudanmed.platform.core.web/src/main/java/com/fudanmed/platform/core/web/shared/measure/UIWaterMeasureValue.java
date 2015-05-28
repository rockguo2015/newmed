package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIWaterMeasureValue extends GWTEntity {
  private Double theValue;
  
  public Double getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final Double theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<UIWaterMeasureValue,Double> TheValueAccessor = new IObjectFieldAccessor<UIWaterMeasureValue,Double>(){
    				public Double getValue(UIWaterMeasureValue object){
    					return object.getTheValue();
    				}
    				public void setValue(UIWaterMeasureValue object,Double value){
    					object.setTheValue(value);
    				}
    			};
  
  private Double incrementalValue;
  
  public Double getIncrementalValue() {
    return this.incrementalValue;
  }
  
  public void setIncrementalValue(final Double incrementalValue) {
    this.incrementalValue = incrementalValue;
  }
  
  public final static String P_IncrementalValue = "incrementalValue";
  
  public static IObjectFieldAccessor<UIWaterMeasureValue,Double> IncrementalValueAccessor = new IObjectFieldAccessor<UIWaterMeasureValue,Double>(){
    				public Double getValue(UIWaterMeasureValue object){
    					return object.getIncrementalValue();
    				}
    				public void setValue(UIWaterMeasureValue object,Double value){
    					object.setIncrementalValue(value);
    				}
    			};
  
  private Date measureDate;
  
  public Date getMeasureDate() {
    return this.measureDate;
  }
  
  public void setMeasureDate(final Date measureDate) {
    this.measureDate = measureDate;
  }
  
  public final static String P_MeasureDate = "measureDate";
  
  public static IObjectFieldAccessor<UIWaterMeasureValue,Date> MeasureDateAccessor = new IObjectFieldAccessor<UIWaterMeasureValue,Date>(){
    				public java.util.Date getValue(UIWaterMeasureValue object){
    					return object.getMeasureDate();
    				}
    				public void setValue(UIWaterMeasureValue object,java.util.Date value){
    					object.setMeasureDate(value);
    				}
    			};
  
  private String measurePerson;
  
  public String getMeasurePerson() {
    return this.measurePerson;
  }
  
  public void setMeasurePerson(final String measurePerson) {
    this.measurePerson = measurePerson;
  }
  
  public final static String P_MeasurePerson = "measurePerson";
  
  public static IObjectFieldAccessor<UIWaterMeasureValue,String> MeasurePersonAccessor = new IObjectFieldAccessor<UIWaterMeasureValue,String>(){
    				public String getValue(UIWaterMeasureValue object){
    					return object.getMeasurePerson();
    				}
    				public void setValue(UIWaterMeasureValue object,String value){
    					object.setMeasurePerson(value);
    				}
    			};
  
  public RCWaterMeasureValueProxy toProxy() {
    return (RCWaterMeasureValueProxy)super.toProxy();
    
  }
}
