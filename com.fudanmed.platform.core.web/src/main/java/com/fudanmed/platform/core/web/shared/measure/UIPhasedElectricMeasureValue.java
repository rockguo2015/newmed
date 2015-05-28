package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIPhasedElectricMeasureValue extends GWTEntity {
  private Double highValue;
  
  public Double getHighValue() {
    return this.highValue;
  }
  
  public void setHighValue(final Double highValue) {
    this.highValue = highValue;
  }
  
  public final static String P_HighValue = "highValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> HighValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getHighValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setHighValue(value);
    				}
    			};
  
  private Double averageValue;
  
  public Double getAverageValue() {
    return this.averageValue;
  }
  
  public void setAverageValue(final Double averageValue) {
    this.averageValue = averageValue;
  }
  
  public final static String P_AverageValue = "averageValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> AverageValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getAverageValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setAverageValue(value);
    				}
    			};
  
  private Double peekValue;
  
  public Double getPeekValue() {
    return this.peekValue;
  }
  
  public void setPeekValue(final Double peekValue) {
    this.peekValue = peekValue;
  }
  
  public final static String P_PeekValue = "peekValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> PeekValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getPeekValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setPeekValue(value);
    				}
    			};
  
  private Double lowValue;
  
  public Double getLowValue() {
    return this.lowValue;
  }
  
  public void setLowValue(final Double lowValue) {
    this.lowValue = lowValue;
  }
  
  public final static String P_LowValue = "lowValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> LowValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getLowValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setLowValue(value);
    				}
    			};
  
  private Double maxRequiredValue;
  
  public Double getMaxRequiredValue() {
    return this.maxRequiredValue;
  }
  
  public void setMaxRequiredValue(final Double maxRequiredValue) {
    this.maxRequiredValue = maxRequiredValue;
  }
  
  public final static String P_MaxRequiredValue = "maxRequiredValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> MaxRequiredValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getMaxRequiredValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setMaxRequiredValue(value);
    				}
    			};
  
  private Double noPowerValue;
  
  public Double getNoPowerValue() {
    return this.noPowerValue;
  }
  
  public void setNoPowerValue(final Double noPowerValue) {
    this.noPowerValue = noPowerValue;
  }
  
  public final static String P_NoPowerValue = "noPowerValue";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> NoPowerValueAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getNoPowerValue();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setNoPowerValue(value);
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
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Date> MeasureDateAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Date>(){
    				public java.util.Date getValue(UIPhasedElectricMeasureValue object){
    					return object.getMeasureDate();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,String> MeasurePersonAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,String>(){
    				public String getValue(UIPhasedElectricMeasureValue object){
    					return object.getMeasurePerson();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,String value){
    					object.setMeasurePerson(value);
    				}
    			};
  
  private Double totalEfficentPower;
  
  public Double getTotalEfficentPower() {
    return this.totalEfficentPower;
  }
  
  public void setTotalEfficentPower(final Double totalEfficentPower) {
    this.totalEfficentPower = totalEfficentPower;
  }
  
  public final static String P_TotalEfficentPower = "totalEfficentPower";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> TotalEfficentPowerAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getTotalEfficentPower();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setTotalEfficentPower(value);
    				}
    			};
  
  private Double consumedPower;
  
  public Double getConsumedPower() {
    return this.consumedPower;
  }
  
  public void setConsumedPower(final Double consumedPower) {
    this.consumedPower = consumedPower;
  }
  
  public final static String P_ConsumedPower = "consumedPower";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double> ConsumedPowerAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureValue,Double>(){
    				public Double getValue(UIPhasedElectricMeasureValue object){
    					return object.getConsumedPower();
    				}
    				public void setValue(UIPhasedElectricMeasureValue object,Double value){
    					object.setConsumedPower(value);
    				}
    			};
  
  public RCPhasedElectricMeasureValueProxy toProxy() {
    return (RCPhasedElectricMeasureValueProxy)super.toProxy();
    
  }
}
