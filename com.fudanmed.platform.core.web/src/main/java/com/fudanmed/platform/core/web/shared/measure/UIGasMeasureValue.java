package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIGasMeasureValue extends GWTEntity {
  private Double theValue;
  
  public Double getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final Double theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<UIGasMeasureValue,Double> TheValueAccessor = new IObjectFieldAccessor<UIGasMeasureValue,Double>(){
    				public Double getValue(UIGasMeasureValue object){
    					return object.getTheValue();
    				}
    				public void setValue(UIGasMeasureValue object,Double value){
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
  
  public static IObjectFieldAccessor<UIGasMeasureValue,Double> IncrementalValueAccessor = new IObjectFieldAccessor<UIGasMeasureValue,Double>(){
    				public Double getValue(UIGasMeasureValue object){
    					return object.getIncrementalValue();
    				}
    				public void setValue(UIGasMeasureValue object,Double value){
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
  
  public static IObjectFieldAccessor<UIGasMeasureValue,Date> MeasureDateAccessor = new IObjectFieldAccessor<UIGasMeasureValue,Date>(){
    				public java.util.Date getValue(UIGasMeasureValue object){
    					return object.getMeasureDate();
    				}
    				public void setValue(UIGasMeasureValue object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIGasMeasureValue,String> MeasurePersonAccessor = new IObjectFieldAccessor<UIGasMeasureValue,String>(){
    				public String getValue(UIGasMeasureValue object){
    					return object.getMeasurePerson();
    				}
    				public void setValue(UIGasMeasureValue object,String value){
    					object.setMeasurePerson(value);
    				}
    			};
  
  public RCGasMeasureValueProxy toProxy() {
    return (RCGasMeasureValueProxy)super.toProxy();
    
  }
}
