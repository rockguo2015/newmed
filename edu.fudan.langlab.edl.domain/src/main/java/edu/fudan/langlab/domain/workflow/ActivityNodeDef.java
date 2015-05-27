package edu.fudan.langlab.domain.workflow;

import edu.fudan.mylang.pf.BaseDataType;

public class ActivityNodeDef extends BaseDataType {
  public ActivityNodeDef() {
    super();
  }
  
  private String activityId;
  
  public String getActivityId() {
    return this.activityId;
  }
  
  public ActivityNodeDef setActivityId(final String activityId) {
    this.activityId = activityId;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public ActivityNodeDef setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  public static ActivityNodeDef create() {
    return new ActivityNodeDef();
    
    
  }
}
