package edu.fudan.langlab.uidl.domain.common.shared.web;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.common.DateRange;
import java.util.Date;

public class UIDateRange implements IsSerializable {
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public void setStartDate(final Date startDate) {
    this.startDate = startDate;
  }
  
  public final static String P_StartDate = "startDate";
  
  public static IObjectFieldAccessor<UIDateRange,Date> StartDateAccessor = new IObjectFieldAccessor<UIDateRange,Date>(){
    				public java.util.Date getValue(UIDateRange object){
    					return object.getStartDate();
    				}
    				public void setValue(UIDateRange object,java.util.Date value){
    					object.setStartDate(value);
    				}
    			};
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<UIDateRange,Date> FinishDateAccessor = new IObjectFieldAccessor<UIDateRange,Date>(){
    				public java.util.Date getValue(UIDateRange object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIDateRange object,java.util.Date value){
    					object.setFinishDate(value);
    				}
    			};
  
  public boolean inRange(final Date d) {
    boolean _and = false;
    boolean _greaterEqualsThan = (d.compareTo(this.startDate) >= 0);
    if (!_greaterEqualsThan) {
      _and = false;
    } else {
      boolean _lessEqualsThan = (d.compareTo(this.finishDate) <= 0);
      _and = (_greaterEqualsThan && _lessEqualsThan);
    }
    return _and;
  }
  
  public boolean inRange(final DateRange range) {
    boolean _or = false;
    Date _startDate = range.getStartDate();
    boolean _inRange = this.inRange(_startDate);
    if (_inRange) {
      _or = true;
    } else {
      Date _finishDate = range.getFinishDate();
      boolean _inRange_1 = this.inRange(_finishDate);
      _or = (_inRange || _inRange_1);
    }
    return _or;
  }
}
