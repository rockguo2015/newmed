package edu.fudan.langlab.domain.common;

import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class DateRange extends BaseDataType {
  public DateRange() {
    super();
  }
  
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public DateRange setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public DateRange setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
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
    boolean _inRange = this.inRange(range.startDate);
    if (_inRange) {
      _or = true;
    } else {
      boolean _inRange_1 = this.inRange(range.finishDate);
      _or = (_inRange || _inRange_1);
    }
    return _or;
  }
  
  public Integer getDurangeInSeconds() {
    long _time = this.finishDate.getTime();
    long _time_1 = this.startDate.getTime();
    long _minus = (_time - _time_1);
    long _divide = (_minus / 1000);
    int _intValue = Long.valueOf(_divide).intValue();
    return Integer.valueOf(_intValue);
  }
  
  public static DateRange create() {
    return new DateRange();
    
    
  }
}
