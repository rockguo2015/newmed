package edu.fudan.langlab.domain.task.impl;

import edu.fudan.langlab.domain.task.NormalTask;
import edu.fudan.langlab.domain.task.impl.TaskImpl;
import edu.fudan.langlab.domain.task.proxy.NormalTaskProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NORMALTASK_TYPE")
public class NormalTaskImpl extends TaskImpl implements NormalTask {
  public NormalTaskImpl() {
    super();
  }
  
  private String taskTypeName;
  
  public String getTaskTypeName() {
    return this.taskTypeName;
  }
  
  public NormalTask setTaskTypeName(final String taskTypeName) {
    this.taskTypeName = taskTypeName;
    return this;			
    
  }
  
  public String getTaskCategory() {
    return "\u63D0\u9192\u4E8B\u9879";
  }
  
  public static NormalTask create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.task.NormalTask normalTask = new edu.fudan.langlab.domain.task.impl.NormalTaskImpl(
    );
    objectFactory.create(normalTask);
    return normalTask;			
    
  }
  
  public NormalTaskProxy toProxy() {
    edu.fudan.langlab.domain.task.proxy.NormalTaskProxy proxy = new edu.fudan.langlab.domain.task.proxy.NormalTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
