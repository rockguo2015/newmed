package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIElectricMeasureValue extends GWTEntity {
  private Double theValue;
  
  public Double getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final Double theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<UIElectricMeasureValue,Double> TheValueAccessor = new IObjectFieldAccessor<UIElectricMeasureValue,Double>(){
    				public Double getValue(UIElectricMeasureValue object){
    					return object.getTheValue();
    				}
    				public void setValue(UIElectricMeasureValue object,Double value){
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
  
  public static IObjectFieldAccessor<UIElectricMeasureValue,Double> IncrementalValueAccessor = new IObjectFieldAccessor<UIElectricMeasureValue,Double>(){
    				public Double getValue(UIElectricMeasureValue object){
    					return object.getIncrementalValue();
    				}
    				public void setValue(UIElectricMeasureValue object,Double value){
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
  
  public static IObjectFieldAccessor<UIElectricMeasureValue,Date> MeasureDateAccessor = new IObjectFieldAccessor<UIElectricMeasureValue,Date>(){
    				public java.util.Date getValue(UIElectricMeasureValue object){
    					return object.getMeasureDate();
    				}
    				public void setValue(UIElectricMeasureValue object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIElectricMeasureValue,String> MeasurePersonAccessor = new IObjectFieldAccessor<UIElectricMeasureValue,String>(){
    				public String getValue(UIElectricMeasureValue object){
    					return object.getMeasurePerson();
    				}
    				public void setValue(UIElectricMeasureValue object,String value){
    					object.setMeasurePerson(value);
    				}
    			};
  
  public RCElectricMeasureValueProxy toProxy() {
    return (RCElectricMeasureValueProxy)super.toProxy();
    
  }
}
