package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIMeasureValue extends GWTEntity {
  private Date measureDate;
  
  public Date getMeasureDate() {
    return this.measureDate;
  }
  
  public void setMeasureDate(final Date measureDate) {
    this.measureDate = measureDate;
  }
  
  public final static String P_MeasureDate = "measureDate";
  
  public static IObjectFieldAccessor<UIMeasureValue,Date> MeasureDateAccessor = new IObjectFieldAccessor<UIMeasureValue,Date>(){
    				public java.util.Date getValue(UIMeasureValue object){
    					return object.getMeasureDate();
    				}
    				public void setValue(UIMeasureValue object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIMeasureValue,String> MeasurePersonAccessor = new IObjectFieldAccessor<UIMeasureValue,String>(){
    				public String getValue(UIMeasureValue object){
    					return object.getMeasurePerson();
    				}
    				public void setValue(UIMeasureValue object,String value){
    					object.setMeasurePerson(value);
    				}
    			};
  
  private String valueString;
  
  public String getValueString() {
    return this.valueString;
  }
  
  public void setValueString(final String valueString) {
    this.valueString = valueString;
  }
  
  public final static String P_ValueString = "valueString";
  
  public static IObjectFieldAccessor<UIMeasureValue,String> ValueStringAccessor = new IObjectFieldAccessor<UIMeasureValue,String>(){
    				public String getValue(UIMeasureValue object){
    					return object.getValueString();
    				}
    				public void setValue(UIMeasureValue object,String value){
    					object.setValueString(value);
    				}
    			};
  
  private String increamentValueString;
  
  public String getIncreamentValueString() {
    return this.increamentValueString;
  }
  
  public void setIncreamentValueString(final String increamentValueString) {
    this.increamentValueString = increamentValueString;
  }
  
  public final static String P_IncreamentValueString = "increamentValueString";
  
  public static IObjectFieldAccessor<UIMeasureValue,String> IncreamentValueStringAccessor = new IObjectFieldAccessor<UIMeasureValue,String>(){
    				public String getValue(UIMeasureValue object){
    					return object.getIncreamentValueString();
    				}
    				public void setValue(UIMeasureValue object,String value){
    					object.setIncreamentValueString(value);
    				}
    			};
  
  public RCMeasureValueProxy toProxy() {
    return (RCMeasureValueProxy)super.toProxy();
    
  }
}
