package com.fudanmed.platform.core.deliver;

import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseDataType;
import java.util.Date;

public class DLPlanDateTime extends BaseDataType {
  public DLPlanDateTime() {
    super();
  }
  
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public DLPlanDateTime setPlanDate(final Date planDate) {
    this.planDate = planDate;
    return this;			
    
  }
  
  private Date planTime;
  
  public Date getPlanTime() {
    return this.planTime;
  }
  
  public DLPlanDateTime setPlanTime(final Date planTime) {
    this.planTime = planTime;
    return this;			
    
  }
  
  public void checkValid() {
    boolean _notEquals = (!Objects.equal(this.planDate, null));
    Validates.Assert(_notEquals, "\u5FC5\u987B\u8BBE\u7F6E\u8BA1\u5212\u65E5\u671F");
  }
  
  public static DLPlanDateTime create() {
    return new DLPlanDateTime();
    
    
  }
}
