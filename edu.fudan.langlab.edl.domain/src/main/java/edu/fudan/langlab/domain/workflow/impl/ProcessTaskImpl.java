package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.task.impl.TaskImpl;
import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.TokenImpl;
import edu.fudan.langlab.domain.workflow.proxy.ProcessTaskProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("PROCESSTASK_TYPE")
public class ProcessTaskImpl extends TaskImpl implements ProcessTask {
  public ProcessTaskImpl() {
    super();
  }
  
  @JoinColumn(name = "token_id")
  @ManyToOne(targetEntity = TokenImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Token token;
  
  public Token getToken() {
    return this.token;
  }
  
  public ProcessTask setToken(final Token token) {
    this.token = token;
    return this;			
    
  }
  
  public String getTaskTypeName() {
    BusinessProcess _bp = this.token.getBp();
    String _processName = _bp.getProcessName();
    String _plus = (_processName + ":");
    ActivityNodeDef _targetActivity = this.token.getTargetActivity();
    String _description = _targetActivity.getDescription();
    String _plus_1 = (_plus + _description);
    return _plus_1;
  }
  
  public String getTaskCategory() {
    return "\u6D41\u7A0B\u4EFB\u52A1";
  }
  
  public static ProcessTask create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.workflow.ProcessTask processTask = new edu.fudan.langlab.domain.workflow.impl.ProcessTaskImpl(
    );
    objectFactory.create(processTask);
    return processTask;			
    
  }
  
  public ProcessTaskProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.ProcessTaskProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.ProcessTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
